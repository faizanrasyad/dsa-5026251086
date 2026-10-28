package src.lw04.prelab;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = scan.nextInt();
        int[] branches = new int[n];

        for (int i = 0; i < n; i++) {
            branches[i] = scan.nextInt();
        }

        int m = scan.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = scan.nextInt();
        }
        
        scan.close();

        // 6 2 10 4 8 1 7 3
        for (int i = 1; i <= 3; i++) {
            int key = branches[i];
            int j = i - 1;

            while (j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = key;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(branches[i] + " ");
        }
        System.out.println("");

        for (int i : targets) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (branches[j] == i) {
                    index = j;
                    break;
                }
            }

            if (index != -1) {
                System.out.println(i + ": FOUND at index " + index);
            } else {
                System.out.println(i + ": NOT FOUND");
            }
        }
    }
}
