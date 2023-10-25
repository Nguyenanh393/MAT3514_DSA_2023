package Hw3_21000663_NguyenNgocAnh.Exercise05;

import java.util.LinkedList;
import java.util.Scanner;


public class Task21 {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        
        for (int i : list) {
            System.out.print(i + " ");
        }

        sc.close();
    }
}
