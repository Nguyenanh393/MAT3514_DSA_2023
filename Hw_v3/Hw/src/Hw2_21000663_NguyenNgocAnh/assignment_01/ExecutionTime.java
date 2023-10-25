package Hw2_21000663_NguyenNgocAnh.assignment_01;

import java.io.*;
import java.util.*;

public class ExecutionTime {
    //read file
    public static void main(String[] args) {
        try {
            File file = new File("case.txt");
            Scanner sc = new Scanner(file);
            ArrayList<Integer[]> arrayIntegers = new ArrayList<>();
            ArrayList<Integer> N = new ArrayList<>();
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
            Double[] bubArray = new Double[80];
            Double[] selArray = new Double[80];
            Double[] insArray = new Double[80];
            Double[] quiArray = new Double[80];
            Double[] merArray = new Double[80];
            
            //execute time
            for (int index = 0; index < 80; index++) {
                execuTime(arrayIntegers.get(index), N.get(index), index, bubArray, selArray, insArray, quiArray, merArray);
                System.out.println("Success..." + index);
            }

            //write file
            try {
                FileWriter writer = new FileWriter("execution_time.txt");

                writer.write("N\tBubble\tSelection\tInsertion\tQuick\tMerge\n");
                for (int i = 0; i < 80; i++) {
                    writer.write(N.get(i) + "\t" + bubArray[i] + "\t" + selArray[i] + "\t" + insArray[i] + "\t" + quiArray[i] + "\t" + merArray[i] + "\n");
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

    //execute time
    public static void execuTime(Integer[] array, Integer n, Integer index, Double[] bubArray, Double[] selArray, Double[] insArray, Double[] quiArray, Double[] merArray) {
        long startTime = System.nanoTime();
        SortAlgorithm.bubbleSort(array, n);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double seconds = (double)duration / 1_000_000_000.0;
        bubArray[index] = seconds;
        
        startTime = System.nanoTime();
        SortAlgorithm.selectionSort(array, n);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        seconds = (double)duration / 1_000_000_000.0;
        selArray[index] = seconds;
        
        startTime = System.nanoTime();
        SortAlgorithm.insertionSort(array, n);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        seconds = (double)duration / 1_000_000_000.0;
        insArray[index] = seconds;
        
        startTime = System.nanoTime();
        SortAlgorithm.quickSort(array, n);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        seconds = (double)duration / 1_000_000_000.0;
        quiArray[index] = seconds;
        
        startTime = System.nanoTime();
        SortAlgorithm.mergeSort(array, n);
        endTime = System.nanoTime();
        duration = (endTime - startTime);
        seconds = (double)duration / 1_000_000_000.0;
        merArray[index] = seconds;
    }
}
