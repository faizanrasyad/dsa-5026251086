package src.lw03.unguided;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanRegister = new Scanner(Main.class.getResourceAsStream("registrations.txt"));

        Set<String> registration = new LinkedHashSet<>();

        while (scanRegister.hasNext()) {
            String register = scanRegister.next();
            registration.add(register);
        }

        Scanner scanCheckin = new Scanner(Main.class.getResourceAsStream("checkins.txt"));

        List<String[]> checkins = new ArrayList<>();
        int successfull = 0, rejected = 0;

        while (scanCheckin.hasNext()) {
            String id = scanCheckin.next();

            if (registration.contains(id)) {
                boolean already = false;
                for (String[] checkin : checkins) {
                    if (checkin[0].equals(id)) {
                        checkins.add(new String[] { id, "Rejected (already checked in)" });
                        rejected++;
                        already = true;
                        break;
                    }
                }

                if (!already) {
                    checkins.add(new String[] { id, "Checked in" });
                    successfull++;
                }

            } else {
                checkins.add(new String[] { id, "Rejected (not registered)" });
                rejected++;
            }
        }

        System.out.println("===== Event Check-In Results =====");

        for (String[] checkin : checkins) {
            System.out.println(checkin[0] + ": " + checkin[1]);
        }

        System.out.println();

        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + registration.size());
        System.out.println("Successful check-ins: " + successfull);
        System.out.println("Absent students: " + (registration.size() - successfull));
        System.out.println("Rejected attempts: " + rejected);
    }
}
