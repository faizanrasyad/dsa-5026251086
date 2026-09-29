package lw02.unguided;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orderList = new LinkedList<>();
        LinkedList<String[]> foodList = new LinkedList<>();
        LinkedList<String[]> drinkList = new LinkedList<>();
        LinkedList<String[]> succesfulOrders = new LinkedList<>();
        Queue<String[]> orderQueue = new LinkedList<>();
        Stack<String[]> failedOrders = new Stack<>();

        Scanner scan = new Scanner(Main.class.getResourceAsStream("orders.txt"));

        while (scan.hasNext()) {
            String[] order = new String[4];
            order[0] = scan.next();
            order[1] = scan.next();
            order[2] = scan.next();
            order[3] = scan.next();
            orderList.add(order);
        }

        foodList.add(new String[] { "Bakso", "2" });
        foodList.add(new String[] { "Sate", "1" });
        foodList.add(new String[] { "Soto", "2" });

        drinkList.add(new String[] { "EsTeh", "4" });
        drinkList.add(new String[] { "EsJeruk", "2" });

        orderQueue.addAll(orderList);

        while (!orderQueue.isEmpty()) {
            String[] order = orderQueue.poll();
            String name = order[0];
            String food = order[1];
            String drink = order[2];
            String table = order[3];

            boolean failed = false;

            if (food != "-") {
                for (String[] currFood : foodList) {
                    String foodName = currFood[0];
                    int foodStock = Integer.parseInt(currFood[1]);
                    if (foodName.equals(food)) {
                        if (foodStock > 0) {
                            foodStock--;
                            foodList.set(foodList.indexOf(currFood),
                                    new String[] { foodName, String.valueOf(foodStock) });
                        } else {
                            failed = true;
                        }
                    }
                }
            }

            if (drink != "-") {
                for (String[] currDrink : drinkList) {
                    String drinkName = currDrink[0];
                    int drinkStock = Integer.parseInt(currDrink[1]);
                    if (drinkName.equals(drink)) {
                        if (drinkStock > 0) {
                            drinkStock--;
                            drinkList.set(drinkList.indexOf(currDrink),
                                    new String[] { drinkName, String.valueOf(drinkStock) });
                        } else {
                            failed = true;
                        }
                    }
                }
            }

            if (failed) {
                failedOrders.add(order);
            } else {
                succesfulOrders.add(order);
            }
        }

        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : succesfulOrders) {
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();

        System.out.println("=== Remaining Food Stock ===");
        for (String[] food : foodList) {
            System.out.println(food[0] + " : " + food[1]);
        }

        System.out.println();

        System.out.println("=== Remaining Drink Stock ===");
        for (String[] drink : drinkList) {
            System.out.println(drink[0] + " : " + drink[1]);
        }

        System.out.println();

        System.out.println("=== Failed Orders ===");
        while (!failedOrders.isEmpty()) {
            String[] order = failedOrders.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

    }
}
