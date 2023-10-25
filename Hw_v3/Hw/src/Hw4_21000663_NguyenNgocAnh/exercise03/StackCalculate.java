package Hw4_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

// Explanation:
// The inputStack() : convert the input string into a stack of strings.
// The isValid() : check if the stack is valid or not.
// The calculate() : calculate the value of the stack. Ìf the stack is not valid, print "Invalid expression" and return.
// The processOperator() : process the operator.
// The priorityOperator() : check the priority of the operator. 
// If (* or /) return 2, if (+ or -) return 1, else (in this exercise is ( or )) return 0.

public class StackCalculate {
    public Stack<String> inputStack(String s) {
        Stack<String> stack = new Stack<String>();
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
        return stack; // return the stack
    }

    // Check if the stack is valid
    public boolean isValid(Stack<String> stack) {
        Stack<String> temp = new Stack<String>();
        for (String element : stack) {
            if (element.equals("(")) { 
                // if the element is (, push it into the stack
                temp.push(element);
            } else if (element.equals(")")) { 
                // if the element is ), check if the stack is empty or not
                if (temp.isEmpty()) { 
                    // if the stack is empty, push the element into the stack
                    temp.push(element);
                } else if (temp.peek().equals("(")) {
                    // if the stack is not empty and the top of the stack is (, pop the top of the stack
                    temp.pop();
                } else {
                    // if the stack is not empty and the top of the stack is not (, push the element into the stack
                    temp.push(element);
                }
        }
    }
        return temp.isEmpty(); // return true if the stack is empty, else return false
    }

    //Calculate if the stack is valid
    public void calculate(Stack<String> stack) {
        if (!isValid(stack)) { 
            // if the stack is not valid, print "Invalid expression" and return
            System.out.println("Invalid expression");
            return;
        }

        Stack<Double> valueStack = new Stack<>(); // create a stack of number
        Stack<String> operatorStack = new Stack<String>(); // create a stack of operator

        for (int i = 0; i < (int) stack.size(); i++) {
            if (stack.get(i).equals("(")) {
                // if the element is (, push it into the stack
                operatorStack.push(stack.get(i));
            } else if (stack.get(i).equals(")")) {
                // if the element is ), pop the operator stack until the top of the stack is (
                while (!operatorStack.peek().equals("(")) {
                    // process the operator and pop it out of the stack
                    // push the result into the value stack
                    processOperator(valueStack, operatorStack.pop());
                }
                operatorStack.pop(); // pop the ( out of the stack
            } else if (stack.get(i).equals("+") || stack.get(i).equals("-") || stack.get(i).equals("*") || stack.get(i).equals("/")) {
                // if the element is an operator
                String operator = stack.get(i);
                // pop the operator stack until the top of the stack is ( or the priority of the top of the stack < the priority of the operator
                while (!operatorStack.isEmpty() && (priorityOperator(operatorStack.peek()) >= priorityOperator(operator))) {
                    // process the operator and pop it out of the stack
                    // push the result into the value stack
                    processOperator(valueStack, operatorStack.pop());
                    operatorStack.pop(); // pop the ( out of the stack
                }
                operatorStack.push(stack.get(i)); // push the operator into the operator stack
            } else { // if the element is a number
                valueStack.push(Double.parseDouble(stack.get(i)));
            }
        }
        if(!operatorStack.isEmpty()) { // if the operator stack is not empty
            processOperator(valueStack, operatorStack.pop());
        }
        System.out.println(valueStack.pop());
    }

    // process the operator
    void processOperator(Stack<Double> stack, String operator) {
        double a = stack.pop();
        double b = stack.pop();
        switch (operator) {
            case "+":
                stack.push(a + b);
                break;
            case "-":
                stack.push(b - a); // b - a because the stack is LIFO
                break;
            case "*":
                stack.push(a * b);
                break;
            case "/":
                stack.push(b / a); // b / a because the stack is LIFO
                break;
        }
    }

    int priorityOperator(String operator) {
        // check the priority of the operator
        // if (* or /) return 2, if (+ or -) return 1, else (in this exercise is ( or )) return 0
        if (operator.equals("*") || operator.equals("/")) {
            return 2;
        } 

        if (operator.equals("+") || operator.equals("-")) {
            return 1;
        }

        return 0;
    }
}
