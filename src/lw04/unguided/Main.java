package src.lw04.unguided;

import java.util.Scanner;

public class Main {
    
    static int[] bubbleSort(int[] array) {
        int n = array.length;
        int[] twoPassArray = new int[n];
        
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            if (i == 1) {
                for (int j = 0; j < n; j++) {
                    twoPassArray[j] = array[j];
                }
            }
        }

        return twoPassArray;
    }

    static void binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int steps = 0;
        int index = -1;

        while (low <= high) {
            steps++;
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                index = mid;
                break;
            } else if (array[mid] > target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (index != -1) {
            System.out.println(target + ": FOUND at index " + index + " (steps: " + steps + ")");
        } else {
            System.out.println(target + ": NOT FOUND (steps: " + steps + ")");
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = scan.nextInt();
        int[] parcels = new int[n];
        for (int i = 0; i < n; i++) {
            parcels[i] = scan.nextInt();
        }

        int nTargets = scan.nextInt();
        int[] targets = new int[nTargets];
        for (int i = 0; i < nTargets; i++) {
            targets[i] = scan.nextInt();
        }

        scan.close();

        int[] twoPassArray = bubbleSort(parcels);

        System.out.println("==== After 2 Passes ====");
        for (int i : twoPassArray) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println("==== Fully Sorted ====");
        for (int i : parcels) {
            System.out.print(i + " ");
        }
        System.out.println("\n");

        System.out.println("==== Search Results ====");
        for (int target : targets) {
            binarySearch(parcels, target);
        }
    }
}
