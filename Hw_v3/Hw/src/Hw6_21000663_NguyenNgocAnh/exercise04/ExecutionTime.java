package Hw6_21000663_NguyenNgocAnh.exercise04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Hw6_21000663_NguyenNgocAnh.exercise01.*;

public class ExecutionTime {
    public static void main(String[] args) {
        try {
            File file = new File("src\\Hw6_21000663_NguyenNgocAnh\\exercise03\\data\\testcase.txt");
            Scanner sc = new Scanner(file);
            ArrayList<Integer[]> arrayIntegers = new ArrayList<>();
            ArrayList<Integer> N = new ArrayList<>();
            String[] PQ = {"unsortedArray", "sortedArray", "unsortedLinked", "sortedLinked"};
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    int n = sc.nextInt();
                    N.add(n);
                    Integer[] array = new Integer[n];
                    for (int i = 0; i < n; i++) {
                        array[i] = sc.nextInt();
                    }
                    arrayIntegers.add(array);
                } else {
                    sc.next();
                }
            }
            System.out.println("Success...");
            
            //create array to store execution time
            Double[][] time = new Double[8][5];
            
            //execute time
            for (int idx1 = 0; idx1 < 4; idx1++) {
                int n = N.get(idx1);
                for (int idx2 = 0; idx2 < 5; idx2++) {
                    execuTime(arrayIntegers.get(idx1), n, idx1, idx2, time);
                }
            }
            //write file
            try {
                FileWriter writer = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise04\\data\\result_table.txt");

                writer.write("Method & PriorityQueue\t10e3\t10e4\t10e5\t10e6\t10e7\n");
                for (int i = 0; i < 4; i++) {
                    writer.write("Insert" + PQ[i] + "\t");
                    for (int j = 0; j < 5; j++) {
                        writer.write(time[i][j] + "\t");
                    }
                    writer.write("\n");
                }
                for (int i = 0; i < 4; i++) {
                    writer.write("RemoveMin" + PQ[i] + "\t");
                    for (int j = 0; j < 5; j++) {
                        writer.write(time[i + 4][j] + "\t");
                    }
                    writer.write("\n");
                }
                writer.close();
                System.out.println("Success...");
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }  
    }

    //execute time
    public static void execuTime(Integer[] array, int n, int idx1, int idx2, Double[][] time) {

        long startTime = System.nanoTime();
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>();
        for (int i = 0; i < n; i++) {
            unsortedArrayPriorityQueue.insert(array[i], i);
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double seconds = (double)duration / 1_000_000_000.0;
        time[idx1][idx2] = seconds;

        startTime = System.nanoTime();
        unsortedArrayPriorityQueue.removeMin();
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        seconds = (double)duration / 1_000_000_000.0;
        time[idx1 + 4][idx2] = seconds;

    }
}