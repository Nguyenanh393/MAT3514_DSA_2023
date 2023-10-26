package Hw5_21000663_NguyenNgocAnh.exercise02;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

public class ExpressionTree<E, T> extends LinkedBinaryTree<E, T>{

    public void preorderPrint() {
        preorderPrint((Node<E>) root);
    }

    private void preorderPrint(Node<E> p) {
        System.out.print(p.getElement() + " ");
        if (left((T) p) != null) {
            preorderPrint((Node<E>) left((T) p));
        }
        if (right((T) p) != null) {
            preorderPrint((Node<E>) right((T) p));
        }
    }

    public void postorderPrint() {
        postorderPrint(root);
    }

    private void postorderPrint(Node<E> p) {
        if (left((T) p) != null) {
            postorderPrint((Node<E>) left((T) p));
        }
        if (right((T) p) != null) {
            postorderPrint((Node<E>) right((T) p));
        }
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint() {
        inorderPrint(root);
    }

    private void inorderPrint(Node<E> p) {
        if (left((T) p) != null) {
            System.out.print("( ");
            inorderPrint((Node<E>) left((T) p));
        }
        System.out.print(p.getElement() + " ");
        if (right((T) p) != null) {
            inorderPrint((Node<E>) right((T) p));
            System.out.print(") ");
        }
    }

    public int calculate() {
        return calculate(root);
    }

    private int calculate(Node<E> p) {
        if (left((T) p) == null && right((T) p) == null) {
            return Integer.parseInt((String) p.getElement());
        }
        int left = calculate((Node<E>) left((T) p));
        int right = calculate((Node<E>) right((T) p));
        switch ((String) p.getElement()) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
        }
        return 0;
    }
}
