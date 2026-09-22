package lw01.unguided;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("washes.txt"));
        
        ArrayList<WashService> washServices = new ArrayList<WashService>();
        int records = scan.nextInt();

        while (records-->0) {
            String type = scan.next();
            String id = scan.next();
            int days = scan.nextInt();
            int units = scan.nextInt();

            if (type.equals("MOTORCYCLE")) {
                washServices.add(new MotorcycleWash(id, days, units));
            } else {
                washServices.add(new CarWash(id, days, units));
            }

        }

        for (WashService washService : washServices) {
            System.out.println(washService.summary());
        }
    }
}
