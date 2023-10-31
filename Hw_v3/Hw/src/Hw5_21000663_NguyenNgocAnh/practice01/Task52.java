package Hw5_21000663_NguyenNgocAnh.practice01;

import java.util.Scanner;

public class Task52 {
    public static long recursion(long n) {
        if (n == 0) return 1;
        return n * recursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        System.out.println(recursion(n));
    }
}
