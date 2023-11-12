package Hw6_21000663_NguyenNgocAnh.exercise06.data;

import java.io.*;
import java.util.*;

public class WriteOrder {
    public static void main(String[] args) {

        Random ran = new Random();
        String[] status = {"buy", "sell"};
        int[] digits = {11, 12, 13, 14, 15, 16, 17, 18, 19};

        try {
            FileWriter fw = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise06\\data\\order.txt");
            fw.write("status quantity price\n");
            for (int i = 0; i < 1000000; i++) {
                fw.write(status[ran.nextInt(2)] + " " + ran.nextDouble()  + " " + (digits[ran.nextInt(1000) % 3] / (double) 100 + 1000) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
