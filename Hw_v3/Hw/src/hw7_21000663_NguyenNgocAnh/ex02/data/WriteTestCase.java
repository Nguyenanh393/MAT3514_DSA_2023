package hw7_21000663_NguyenNgocAnh.ex02.data;

import java.io.FileWriter;
import java.util.Random;

public class WriteTestCase {
    public static void main(String[] args) {
        Integer[] N = {1000000, 10000000};
        Random ran = new Random();
        try {
            FileWriter fw = new FileWriter("hw7_21000663_NguyenNgocAnh\\ex01\\data\\testcase.txt");
            for (int n : N) {
                fw.write(n + "\n");
                for (int j = 0; j < n; j++) {
                    fw.write(ran.nextInt(0, 1000000000) + " ");
                }
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }
}
