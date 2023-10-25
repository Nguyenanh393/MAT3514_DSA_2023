package Hw4_21000663_NguyenNgocAnh.practice01;

import java.util.*;

public class Task13 {
    static String stack(String s) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            result += stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(stack(s));
        sc.close();
    }
}
