package Hw5_21000663_NguyenNgocAnh.exercise03;

import java.util.*;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

import Hw5_21000663_NguyenNgocAnh.exercise02.ExpressionTree;

public class StringToTree {
    public static boolean isValid(String s) {
        // check if the string is valid
        // if the string is valid, return true, else return false
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // if the character is (, increase the count
                count++;
            } else if (s.charAt(i) == ')') { // if the character is ), decrease the count
                count--;
            }
            if (count < 0) { // if the count is less than 0, return false
                return false;
            }
        }
        if (count == 0) { // if the count is equal to 0, return true
            return true;
        }
        return false;
    }

    public static boolean isValid(String[] s) {
        // check if the array of token is valid
        // if the array of token is valid, return true, else return false
        int count = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("(")) { // if the character is (, increase the count
                count++;
            } else if (s[i].equals(")")) { // if the character is ), decrease the count
                count--;
            }
            if (count < 0) { // if the count is less than 0, return false
                return false;
            }
        }
        if (count == 0) { // if the count is equal to 0, return true
            return true;
        }
        return false;
    }

    public static boolean isOnlyOperator(String s) {
        // check if the string is only operator
        // if the string is only operator, return true, else return false
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > 47 || s.charAt(i) < 40) { // if the character is a number, return false
                return false;
            }
        }
        return true;
    }

    public static Stack<String> convertToStack(String s) {
        Stack<String> stack = new Stack<String>();
        String temp = "";
        for (int i = 0; i < s.length(); ) {
            temp = "";
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
        if (temp != "") { // if the temp is not empty, push it into the stack
            stack.push(temp);
        }
        return stack; // return the stack
}

    public static Stack<String> convertToStack(String[] s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length; i++) {
            stack.push(s[i]);
        }
        return stack;
    }

    private static Stack<String> infixToPostfix(Stack<String> stack) {
        Stack<String> postfixStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();

        for (int i = 0; i < stack.size(); i++) {
            String temp = stack.get(i);
            if (temp.equals("(")) { // if the character is (, push it into the operator stack
                operatorStack.push(temp);
            } else if (temp.equals(")")) { // if the character is ), pop all the operator in the operator stack until meet (
                while (!operatorStack.peek().equals("(")) {
                    postfixStack.push(operatorStack.pop());
                }
                operatorStack.pop();
            } else if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) { // if the character is an operator
                if (operatorStack.isEmpty()) { // if the operator stack is empty, push the operator into the operator stack
                    operatorStack.push(temp);
                } else {
                    while (!operatorStack.isEmpty() && priorityOperator(operatorStack.peek()) >= priorityOperator(temp)) {
                        // if the operator stack is not empty and the priority of the operator in the operator stack is greater than or equal to the priority of the operator, pop the operator in the operator stack and push it into the postfix stack
                        postfixStack.push(operatorStack.pop());
                    }
                    operatorStack.push(temp); // push the operator into the operator stack
                }
            } else { // if the character is a number, push it into the postfix stack
                postfixStack.push(temp);
            }
        }
        if (!operatorStack.isEmpty()) { // if the operator stack is not empty, pop all the operator in the operator stack and push it into the postfix stack
            while (!operatorStack.isEmpty()) {
                postfixStack.push(operatorStack.pop());
            }
        }
        return postfixStack; // return the postfix stack
    }

    private static int priorityOperator(String operator) {
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

    private static LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> convertPostStackToTree(Stack<String> stack) {
        Stack<LinkedBinaryTree<String, LinkedBinaryTree.Node<String>>> treeStack = new Stack<>();
        for (int i = 0; i < stack.size(); i++) {
            String temp = stack.get(i);
            if (temp.equals("+") || temp.equals("-") || temp.equals("*") || temp.equals("/")) { // if the character is an operator
                LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = new LinkedBinaryTree<>();
                LinkedBinaryTree.Node<String> node = tree.addRoot(temp); // create a node with the label is the operator
                node.right = treeStack.pop().root; // pop a operand from the tree stack and set it to the right child of the node
                node.left = treeStack.pop().root; // pop a operand from the tree stack and set it to the left child of the node
                treeStack.push(tree); // push the node into the tree stack
            } else { // if the character is a number
                LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = new LinkedBinaryTree<>();
                tree.addRoot(temp); // create a node with the label is the number
                treeStack.push(tree); // push the node into the tree stack
            }
        }
        return treeStack.pop(); // return the root of the tree
    }

    private static int calculateTree(LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree) {
        ExpressionTree<String, LinkedBinaryTree.Node<String>> ExpressionTree = new ExpressionTree<>();
        ExpressionTree.root = tree.root;

        return ExpressionTree.calculate();
    } 

    public static LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> convertToTree(String s) { 
        Stack<String> stack = convertToStack(s);
        Stack<String> postfixStack = infixToPostfix(stack);
        return convertPostStackToTree(postfixStack);
    }

    public static int calculateTree(String s) {
        LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = convertToTree(s);
        return calculateTree(tree);
    }

    public static LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> convertToTree(String[] s) {
        Stack<String> stack = convertToStack(s);
        Stack<String> postfixStack = infixToPostfix(stack);
        return convertPostStackToTree(postfixStack);
    }

    public static int calculateTree(String[] s) {
        LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = convertToTree(s);
        return calculateTree(tree);
    }

    public static void Test(String str) {
        if (isValid(str)) {
            if (str.isEmpty()) {
                System.out.println("The string is empty");
            } else {
                System.out.printf("The string \'%s\' is valid \n", str);

                if (isOnlyOperator(str)) {
                    System.out.println("The string is only operator");
                } else {
                    LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = convertToTree(str);
                    tree.printTree();
                    System.out.println(calculateTree(str));
                }
            }
        } else {
            System.out.printf("The string \'%s\' is not valid \n", str);
        }
    }

    public static void Test(String[] str) {
        if (isValid(str)) {
            if (str.length == 0) {
                System.out.println("The array of token is empty");
            } else {
                System.out.printf("The array of token \'*%s\' is valid \n", Arrays.toString(str));
                
                if (isOnlyOperator(Arrays.toString(str))) {
                    System.out.println("The array of token is only operator");
                } else {
                    LinkedBinaryTree<String, LinkedBinaryTree.Node<String>> tree = convertToTree(str);
                    tree.printTree();
                    System.out.println(calculateTree(str));
                }
            }
        } else {
            System.out.printf("The array of token \'*%s\' is not valid \n", Arrays.toString(str));
        }
    }
}