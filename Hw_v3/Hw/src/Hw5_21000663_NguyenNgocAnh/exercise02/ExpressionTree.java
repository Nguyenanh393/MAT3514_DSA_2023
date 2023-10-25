package Hw5_21000663_NguyenNgocAnh.exercise02;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

public class ExpressionTree<E, T> extends LinkedBinaryTree<E, T>{

    public void preorderPrint(Node<E> p) {
        System.out.print(p.getElement() + " ");
        if (left((T) p) != null) {
            preorderPrint((Node<E>) left((T) p));
        }
        if (right((T) p) != null) {
            preorderPrint((Node<E>) right((T) p));
        }
    }

    public void postorderPrint(Node<E> p) {
        if (left((T) p) != null) {
            postorderPrint((Node<E>) left((T) p));
        }
        if (right((T) p) != null) {
            postorderPrint((Node<E>) right((T) p));
        }
        System.out.print(p.getElement() + " ");
    }

    public void inorderPrint(Node<E> p) {
        if (left((T) p) != null) {
            inorderPrint((Node<E>) left((T) p));
        }
        System.out.print(p.getElement() + " ");
        if (right((T) p) != null) {
            inorderPrint((Node<E>) right((T) p));
        }
    }

}
