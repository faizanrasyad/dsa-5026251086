import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(Main.class.getResourceAsStream("jobs.txt"));
        
        ArrayList<PrintJob> printJob = new ArrayList<PrintJob>();

        while (scan.hasNext()) {
            String type = scan.next();
            String id = scan.next();
            int pages = scan.nextInt();

            if (type.equals("MONO")) {
                printJob.add(new MonoPrint(id, pages));
            } else if (type.equals("COLOUR")) {
                printJob.add(new ColourPrint(id, pages));
            }
        }

        for (PrintJob countPrintJob : printJob) {
            System.out.println(countPrintJob.summary());            
        }
    }
}
