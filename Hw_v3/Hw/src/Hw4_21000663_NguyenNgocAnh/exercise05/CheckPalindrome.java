package Hw4_21000663_NguyenNgocAnh.exercise05;

import Hw4_21000663_NguyenNgocAnh.exercise02.LinkedListStack;
import Hw4_21000663_NguyenNgocAnh.exercise04.LinkedListQueue;

public class CheckPalindrome {
    // Không phân biệt hoa thường, không phân biệt khoảng trắng.
    public static boolean isPalindrome(String s) {
        LinkedListQueue<Character> queue = new LinkedListQueue<>();
        LinkedListStack<Character> stack = new LinkedListStack<>();
        String lowerCase = s.toLowerCase(); // chuyển về chữ thường
        for (int i = 0; i < lowerCase.length(); i++) { // duyệt qua từng kí tự
            char c = lowerCase.charAt(i); // lấy kí tự thứ i
            if (c != ' ') { // nếu kí tự thứ i khác khoảng trắng thì thêm vào queue và stack
                queue.enqueue(c);
                stack.push(c);
            }
        }
        while (!queue.isEmpty()) { // duyệt qua queue và stack để so sánh
            if (!queue.dequeue().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }
}
