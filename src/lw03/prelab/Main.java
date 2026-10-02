package src.lw03.prelab;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        problemaUno();
        problemaDos();
        problemaTres();

    }

    private static void problemaUno() {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new LinkedList<>();

        while (scan.hasNextLine()) {
            String[] queue = scan.nextLine().split(" ", 2);
            String type = queue[0];
            String song = queue[1];

            switch (type) {
                case "ADD":
                    playlist.add(song);
                    break;
                case "INSERT":
                    String[] insertQueue = queue[1].split(" ", 2);
                    int index = Integer.parseInt(insertQueue[0]);
                    song = insertQueue[1];
                    playlist.add(index, song);
                    break;
                case "REMOVE":
                    if (playlist.contains(song)) {
                        playlist.remove(song);
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        int i = 1;
        for (String song : playlist) {
            System.out.println(i++ + ": " + song);
        }
        System.out.println();
    }

    private static void problemaDos() {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;

        while (scan.hasNext()) {
            String name = scan.next();
            if (!participants.contains(name)) {
                participants.add(name);
            } else {
                duplicate++;
            }
        }

        System.out.println("==== Problem 2 ====");
        System.out.println("Unique participants: " + participants.size());
        int i = 1;
        for (String name : participants) {
            System.out.println(i++ + ". " + name);
        }
        System.out.println("Duplicate registrations: " + duplicate);
        System.out.println();

    }

    private static void problemaTres() {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failed = 0;

        while (scan.hasNextLine()) {
            String[] product = scan.nextLine().split(" ");
            String type = product[0];
            String name = product[1];
            int qty = Integer.parseInt(product[2]);

            switch (type) {
                case "ADD":
                    inventory.put(name, inventory.getOrDefault(name, 0) + qty);
                    break;
                case "SELL":
                    int stock = inventory.getOrDefault(name, 0);
                    if (qty > stock) {
                        failed++;
                    } else {
                        inventory.put(name, inventory.getOrDefault(name, 0) - qty);
                    }
                    break;
                default:
                    break;
            }
        }

        System.out.println("===== Problem 3 =====");
        for (Map.Entry<String, Integer> order : inventory.entrySet()) {
            System.out.println(order.getKey() + ": " + order.getValue());
        }
        System.out.println("Failed sales: " + failed);
    }
}
