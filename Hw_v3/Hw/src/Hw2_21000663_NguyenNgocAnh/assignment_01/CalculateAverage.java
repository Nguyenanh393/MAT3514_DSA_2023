package Hw2_21000663_NguyenNgocAnh.assignment_01;

import java.io.*;
import java.util.*;

public class CalculateAverage {
    public static void main(String[] args) {
        //read file ExecutionTime.txt
        try {
            File file = new File("execution_time.txt");
            Scanner sc = new Scanner(file);
            ArrayList<Integer> N = new ArrayList<>();
            ArrayList<Double> bubArray = new ArrayList<>();
            ArrayList<Double> selArray = new ArrayList<>();
            ArrayList<Double> insArray = new ArrayList<>();
            ArrayList<Double> quiArray = new ArrayList<>();
            ArrayList<Double> merArray = new ArrayList<>();
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    int n = sc.nextInt();
                    N.add(n);
                    bubArray.add(sc.nextDouble());
                    selArray.add(sc.nextDouble());
                    insArray.add(sc.nextDouble());
                    quiArray.add(sc.nextDouble());
                    merArray.add(sc.nextDouble());
                } else {
                    sc.next();
                }
            }
            System.out.println("Success...");
            //average execution time each different value of N
            //bubble sort
            Double[] bubArrayAvg = new Double[4];
            for (int i = 0; i < 4; i++) {
                Double sum = 0.0;
                for (int j = 0; j < 20; j++) {
                    sum += bubArray.get(i * 20 + j);
                }
                bubArrayAvg[i] = sum / 20;
            }
            //selection sort
            Double[] selArrayAvg = new Double[4];
            for (int i = 0; i < 4; i++) {
                Double sum = 0.0;
                for (int j = 0; j < 20; j++) {
                    sum += selArray.get(i * 20 + j);
                }
                selArrayAvg[i] = sum / 20;
            }
            //insertion sort
            Double[] insArrayAvg = new Double[4];
            for (int i = 0; i < 4; i++) {
                Double sum = 0.0;
                for (int j = 0; j < 20; j++) {
                    sum += insArray.get(i * 20 + j);
                }
                insArrayAvg[i] = sum / 20;
            }
            //quick sort
            Double[] quiArrayAvg = new Double[4];
            for (int i = 0; i < 4; i++) {
                Double sum = 0.0;
                for (int j = 0; j < 20; j++) {
                    sum += quiArray.get(i * 20 + j);
                }
                quiArrayAvg[i] = sum / 20;
            }
            //merge sort
            Double[] merArrayAvg = new Double[4];
            for (int i = 0; i < 4; i++) {
                Double sum = 0.0;
                for (int j = 0; j < 20; j++) {
                    sum += merArray.get(i * 20 + j);
                }
                merArrayAvg[i] = sum / 20;
            }
            
            // write file
            try {
                FileWriter writer = new FileWriter("average_execution_time.txt");

                writer.write("N\tBubble\tSelection\tInsertion\tQuick\tMerge\n");
                for (int i = 0; i < 4; i++) {
                    writer.write(N.get(i * 20) + "\t" + bubArrayAvg[i] + "\t" + selArrayAvg[i] + "\t" + insArrayAvg[i] + "\t" + quiArrayAvg[i] + "\t" + merArrayAvg[i] + "\n");
                }
                writer.close();
                System.out.println("Success...");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            sc.close(); 
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
