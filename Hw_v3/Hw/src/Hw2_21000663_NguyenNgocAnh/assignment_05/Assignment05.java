package Hw2_21000663_NguyenNgocAnh.assignment_05;

import java.util.*;

public class Assignment05 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i=0; i<n; i++) {
            a[i] = sc.nextInt();
        }

        Arrays.sort(a);

        for(int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }

        sc.close();
    }
}