package Hw6_21000663_NguyenNgocAnh.exercise04.data;

import java.io.*;
import java.util.*;

public class WriteTestCase {
    public static void main(String[] args) {
        Integer[] N = {1000, 10000, 100000, 1000000, 10000000};
        Random ran = new Random();
        try {
            FileWriter fw = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise04\\data\\testcase.txt");
            for (int n : N) {
                for (int i = 0; i < 1; i++) {
                    fw.write(n + "\n");
                    for (int j = 0; j < n; j++) {
                        fw.write(ran.nextInt(0, 1000000000) + " ");
                    }
                    fw.write("\n");
                }
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
