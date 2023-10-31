package Hw5_21000663_NguyenNgocAnh.practice01;

import java.util.Scanner;

public class Task53 {
    public static long pow(long a, long b) {
        if (b == 0) return 1;
        return a * pow(a, b - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong();
        sc.close();
        System.out.println(pow(a, b));
    }
}
