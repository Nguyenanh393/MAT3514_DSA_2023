package hw7_21000663_NguyenNgocAnh.ex02.data;

import java.io.*;
import java.util.*;

public class WriteRandomFind {
    public static void main(String[] args) {
        Random ran = new Random();
        try {
            // read data from file testcase.txt
            File file = new File("hw7_21000663_NguyenNgocAnh\\ex01\\data\\testcase.txt");
            Scanner sc = new Scanner(file);

            FileWriter fw = new FileWriter("hw7_21000663_NguyenNgocAnh\\ex01\\data\\random_find_element.txt");
            while (sc.hasNextLine()) {
                int n = Integer.parseInt(sc.nextLine());
                String[] arr = sc.nextLine().split(" ");
                int[] a = new int[n];
                for (int i = 0; i < n; i++) {
                    a[i] = Integer.parseInt(arr[i]);
                }

                fw.write(n + "\n");
                for (int i = 0; i < 10; i++) {
                    fw.write(a[ran.nextInt(0, n)] + " ");
                }
                for (int i = 0; i < 10; i++) {
                    fw.write(ran.nextInt(1000000000, 2000000000) + " ");
                }
                fw.write("\n");
            } 
            fw.close();
            System.out.println("Success...");     
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
