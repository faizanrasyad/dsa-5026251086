package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        LinkedList<String[]> transactionList = new LinkedList<String[]>();
        LinkedList<String[]> customerList = new LinkedList<String[]>();
        Queue<String[]> transactionProcessed = new LinkedList<>();
        Stack<String[]> failedTransactions = new Stack<>();

        while (scan.hasNextLine()) {
            String[] transaction = scan.nextLine().split(" ");
            transactionList.add(transaction);
        }

        for (String[] transaction : transactionList) {
            String name = transaction[0];
            boolean exists = false;
            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                // Add customer name and balance into the LinkedList
                customerList.add(new String[] { name, "0" });
            }
        }

        while (!transactionList.isEmpty()) {
            transactionProcessed.add(transactionList.poll());
        }

        while (!transactionProcessed.isEmpty()) {
            String[] transaction = transactionProcessed.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (String[] customer : customerList) {
                if (customer[0].equals(name)) {
                    int balance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")) {
                        balance += amount;
                        customer[1] = String.valueOf(balance);
                    } else {
                        if (amount > balance) {
                            failedTransactions.push(transaction);
                        } else {
                            balance -= amount;
                            customer[1] = String.valueOf(balance);
                        }
                    }

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] customer : customerList) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("");
        System.out.println("=== Failed Transactions ===");
        while (!failedTransactions.isEmpty()) {
            String[] transaction = failedTransactions.pop();
            System.out.println(transaction[0] + " " + transaction[1] + " " + transaction[2]);
        }

    }
}
