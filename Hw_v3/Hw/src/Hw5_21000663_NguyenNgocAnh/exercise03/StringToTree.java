package Hw5_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

public class StringToTree {
    public static Stack<String> convertStringToStack(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            String temp = "";
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == ' ') { // ignore the space
                    i = j + 1;
                    continue;
                }
                if (s.charAt(j) == '+' || s.charAt(j) == '-' || s.charAt(j) == '*' || s.charAt(j) == '/' || s.charAt(j) == '(' || s.charAt(j) == ')') {
                    // if the temp is not empty, push it into the stack
                    if (temp != "") { 
                        stack.push(temp);
                        temp = "";
                    }
                    // push the operator into the stack
                    stack.push(String.valueOf(s.charAt(j)));
                    i = j + 1;
                    break;
                } else { // if the character is a number, add it to the temp string
                    temp += s.charAt(j);
                    i = j + 1;
                }
            }
        }

        // Stack<String> reverseStack = new Stack<>();

        // while(!stack.isEmpty()){
        //     reverseStack.push(stack.pop());
        // }
        return stack; // return the stack
    }

    public static Stack<String> infixToPostfix(Stack<String> stack) {
        
        Stack<String> outputStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        Stack<String> valueStack = new Stack<>();

        for(int i = 0; i < stack.size(); i++) {
            if (stack.get(i).equals("(")) {
                operatorStack.push(stack.get(i));
            }

            if(stack.get(i).equals(")")) {
                while(!valueStack.isEmpty()) {
                    outputStack.push(valueStack.pop());
                }
                while(!operatorStack.peek().equals("(")) {
                    outputStack.push(operatorStack.pop());
                }
                operatorStack.pop();
            }
            valueStack.push(stack.get(i));
        }
        return outputStack;
    }

    // int priorityOperator(String operator) {
    //     // check the priority of the operator
    //     // if (* or /) return 2, if (+ or -) return 1, else (in this exercise is ( or )) return 0
    //     if (operator.equals("*") || operator.equals("/")) {
    //         return 2;
    //     } 

    //     if (operator.equals("+") || operator.equals("-")) {
    //         return 1;
    //     }

    //     return 0;
    // }
}
