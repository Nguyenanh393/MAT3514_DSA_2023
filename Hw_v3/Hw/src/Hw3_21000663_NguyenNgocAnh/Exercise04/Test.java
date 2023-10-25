package Hw3_21000663_NguyenNgocAnh.Exercise04;

import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // read file
        try {
            File file = new File("D:\\Github\\MAT3514_DSA_2023\\Hw_v3\\Hw\\src\\Hw3_21000663_NguyenNgocAnh\\Exercise04\\text.txt");
            Scanner sc = new Scanner(file);
            String[] words = sc.nextLine().split(" ");

            // process words
            for (int i = 0; i < words.length; i++) {
                // remove punctuation
                words[i] = words[i].replaceAll("[^a-zA-Z0-9]", "");
                // remove empty string
                if (words[i].isEmpty()) {
                    words[i] = null;
                }
                // to lower case
                assert words[i] != null;
                words[i] = words[i].toLowerCase();
            }

            // word to lower case
            for (int i = 0; i < words.length; i++) {
                words[i] = words[i].toLowerCase();
            }
            sc.close();

            // write to file
            FileWriter writer = new FileWriter("D:\\Github\\MAT3514_DSA_2023\\Hw_v3\\Hw\\src\\Hw3_21000663_NguyenNgocAnh\\Exercise04\\output.txt");
            for (String word : words) {
                writer.write(word + " ");
            }
            writer.close();
            // create list
            ListDemo<String> list = new SimpleArrayList<>();
            // add words to list
            for (String word : words) {
                if (word != null) {
                    list.add(word);
                }
            }
            // count words
            ListDemo<WordCount> wordCountList = new SimpleArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                WordCount wordCount = new WordCount(list.get(i), 1);
                if (wordCountList.isContain(wordCount)) {
                    int idx = wordCountList.indexOf(wordCount); // get index of wordCount in wordCountList
                    wordCountList.get(idx).setCount(wordCountList.get(idx).getCount() + 1); // increase count
                } else {
                    wordCountList.add(wordCount); // add wordCount to wordCountList
                }
            }
            // write to file
            FileWriter writer2 = new FileWriter("D:\\Github\\MAT3514_DSA_2023\\Hw_v3\\Hw\\src\\Hw3_21000663_NguyenNgocAnh\\Exercise04\\output2.txt");
            for (int i = 0; i < wordCountList.size(); i++) {
                writer2.write(wordCountList.get(i).toString() + "\n");
            }
            writer2.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
