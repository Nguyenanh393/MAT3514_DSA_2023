package Hw4_21000663_NguyenNgocAnh.exercise01;

import java.util.Stack;

public class StackName {
    public static void main(String[] args) {

        Stack<Character> s = new Stack<>();
        String hoten = "Nguyen Ngoc Anh";
        for (int i = 0; i < hoten.length(); i++) {
            if (i % 2 == 0) {
                s.push(hoten.charAt(i));
            }

            if (i % 3 == 0) {
                s.pop();
            }
        }
        System.out.println(s);
    }
}
// [e, c, h]