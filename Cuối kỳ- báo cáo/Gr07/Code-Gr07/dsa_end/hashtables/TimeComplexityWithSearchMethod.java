package dsa_end.hashtables;

import java.io.*;

public class TimeComplexityWithSearchMethod {
    public static void writeTestcase(){
        try {
            FileWriter fileWrite = new FileWriter("dsa_end\\hashtables\\testcase.txt", true);
            for (int i = 100; i <= 100000; i *= 10) {
                fileWrite.write(i + "\n");
                for (int j = 0; j < i; j++) {
                    fileWrite.write((int) (Math.random() * 10000) + " ");
                }
                fileWrite.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    

    public static void timeComplexityWithSearchMethod() {
        try {
            FileReader fileRead = new FileReader("dsa_end\\hashtables\\testcase.txt");
            BufferedReader bufferedReader = new BufferedReader(fileRead);
            String line = bufferedReader.readLine();
            while (line != null) {
                int capacity = Integer.parseInt(line);
                SeparateChainingHash<Integer, Integer> separateChainingHash = new SeparateChainingHash<>(13);
                LinearProbingHash<Integer, Integer> linearProbingHash = new LinearProbingHash<>(13);
                line = bufferedReader.readLine();
                String[] numbers = line.split(" ");
                for (int i = 0; i < numbers.length; i++) {
                    int number = Integer.parseInt(numbers[i]);
                    separateChainingHash.insert(number, number);
                    linearProbingHash.insert(number, number);
                }
                System.out.println("Done read: " + capacity);
                double[][] timeComplexity = new double[2][numbers.length];
                for (int i = 0; i < numbers.length; i++) {
                    System.out.println("Start search: " + numbers[i]);
                    long startTime = System.nanoTime();
                    separateChainingHash.search(Integer.parseInt(numbers[i]));
                    long endTime = System.nanoTime();
                    timeComplexity[0][i] = (double) (endTime - startTime) / 1000; 
                    startTime = System.nanoTime();
                    linearProbingHash.search(Integer.parseInt(numbers[i]));
                    endTime = System.nanoTime();
                    timeComplexity[1][i] = (double) (endTime - startTime) / 1000;

                    System.out.println("Done search: " + numbers[i]);
                }
                // write time complexity to file
                FileWriter fileWrite = new FileWriter("dsa_end\\hashtables\\timeComplexityWithSearchMethod.txt", true);
                fileWrite.write(capacity + "\n");
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < numbers.length; j++) {
                        fileWrite.write(timeComplexity[i][j] + " ");
                    }
                    fileWrite.write("\n");
                }
                fileWrite.close();
                
                line = bufferedReader.readLine();

                System.out.println("Done " + capacity);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error");
        }   
    }

    public static void main(String[] args) {
        writeTestcase();
        timeComplexityWithSearchMethod();
    }
}
