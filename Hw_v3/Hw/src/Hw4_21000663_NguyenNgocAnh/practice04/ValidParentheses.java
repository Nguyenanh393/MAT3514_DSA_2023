package Hw4_21000663_NguyenNgocAnh.practice04;

import java.util.*;

public class ValidParentheses {
    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') { // push opening brackets
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) { // if the stack is empty, return false
                        return false;
                    }
                    char top = stack.pop(); // pop the top of the stack
                    // check if the top of the stack is the corresponding opening bracket
                    if (c == ')' && top != '(') { 
                        return false;
                    }
                    if (c == '}' && top != '{') {
                        return false;
                    }
                    if (c == ']' && top != '[') {
                        return false;
                    }
                }
            }
            return stack.isEmpty(); 
        }
    }
}
