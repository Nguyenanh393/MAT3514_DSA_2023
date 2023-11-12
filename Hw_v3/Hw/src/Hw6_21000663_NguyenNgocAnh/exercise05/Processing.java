package Hw6_21000663_NguyenNgocAnh.exercise05;

import java.io.*;
import java.util.*;

public class Processing {
    public static void main(String[] args) { 
        try {
            System.out.println("Start reading...");
            File file = new File("src\\Hw6_21000663_NguyenNgocAnh\\exercise05\\data\\time.txt");
            Scanner sc = new Scanner(file);
            String line;
            AirTrafficControl airTrafficPQ = new AirTrafficControl();
            int count1 = 0;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                String[] arr = line.split(" ");
                Event e = new Event(Double.parseDouble(arr[1].split(":")[0]) + Double.parseDouble(arr[1].split(":")[1]) / 60, arr[0]);
                airTrafficPQ.addEvent(e);
                count1++;

                if (count1 % 1000 == 0) {
                    System.out.println("Reading..." + count1);
                }
            }
            System.out.println("Success reading...");
            sc.close();

            System.out.println("Start processing...");
            try {
                int count2 = 0;
                FileWriter fw = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise05\\data\\processing.txt");
                while (!airTrafficPQ.isEmpty()) {
                    fw.write(airTrafficPQ.getEvent().toString() + "\n");
                    airTrafficPQ.processEvent();
                    count2++;
                    if (count2 % 1000 == 0) {
                        System.out.println("Processing..." + count2);
                    }
                }
                fw.close();
                System.out.println("Success processing...");
            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
