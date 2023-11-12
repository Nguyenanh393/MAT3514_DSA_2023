package Hw6_21000663_NguyenNgocAnh.exercise05;

import java.io.*;
import java.util.*;

public class WriteTimeFile {
    public static void main(String[] args) {
        Random ran = new Random();
        // sự kiện cất/hạ cánh viết theo dạng: takeoff/landing time (vd: takeoff 8:00)
        String[] event = {"takeoff", "landing"};
        try {
            FileWriter fw = new FileWriter("src\\Hw6_21000663_NguyenNgocAnh\\exercise05\\data\\time.txt");
            for (int i = 0; i < 100000; i++) {
                fw.write(event[ran.nextInt(0, 2)] + " " + ran.nextInt(0, 24) + ":" + ran.nextInt(0, 60) + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
