package hw7_21000663_NguyenNgocAnh.ex02;

import java.io.*;
import java.util.*;

public class CalculateAverage {
    public static void main(String[] args) {
        // read file result.txt
        try {
            File file = new File("hw7_21000663_NguyenNgocAnh\\ex02\\data\\result.txt");
            Scanner sc = new Scanner(file);
            double[] avrg = new double[6];
            int index = 0;
            for (int i = 0; i < 2; i++) {
                sc.nextLine();
                for (int j = 0; j < 3; j++) {
                    sc.nextLine();
                    String[] arr = sc.nextLine().split(" ");
                    double s = 0;
                    for (int k = 0; k < 20; k++) {
                        s += Double.parseDouble(arr[k]);
                    }
                    avrg[index] = s / 20;
                    index++;
                }
            }

            // write file average.txt
            try {
            FileWriter fw = new FileWriter("hw7_21000663_NguyenNgocAnh\\ex02\\data\\average.txt");
            fw.write("N" + "\t" + "Sequential Search Algorithm" + "\t" + "Binary Search Algorithm" + "\t"
                    + "Binary Search Tree Algorithm" + "\n");
            fw.write("1000000" + "\t" + avrg[0] + "\t" + avrg[1] + "\t" + avrg[2] + "\n");
            fw.write("10000000" + "\t" + avrg[3] + "\t" + avrg[4] + "\t" + avrg[5] + "\n");
            fw.close();
            System.out.println("Success...");

            } catch (Exception e) {
                System.out.println(e);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
