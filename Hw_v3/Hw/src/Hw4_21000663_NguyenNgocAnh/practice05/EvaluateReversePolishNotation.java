package Hw4_21000663_NguyenNgocAnh.practice05;

import java.util.*;

public class EvaluateReversePolishNotation {
    // Evaluate Reverse Polish Notation example: 3 4 × 5 6 × +

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if (token.equals("+")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a);
                } else if (token.equals("*")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b / a);
                } else {
                    stack.push(Integer.parseInt(token));
                }
            }
            return stack.pop();
        }
    }
}
