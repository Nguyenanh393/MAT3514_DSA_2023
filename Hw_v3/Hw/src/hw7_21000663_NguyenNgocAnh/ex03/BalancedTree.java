package hw7_21000663_NguyenNgocAnh.ex03;

import hw7_21000663_NguyenNgocAnh.ex02.BST;
public class BalancedTree<E extends Comparable<E> , T> extends BST<E, T> implements BalancedSearchTree<E, T>{

    @Override
    public void rotateLeft(T p) {
        Node<T> node = (Node<T>) p;
        Node<T> temp = node.right;
        node.right = temp.left;
        if (temp.left != null) {
            temp.left.parent = node;
        }
        temp.parent = node.parent; 
        if (node.parent == null) {
            root = (Node<E>) temp; 
        } else if (node == node.parent.left) {
            node.parent.left = temp; 
        } else {
            node.parent.right = temp; 
        }
        temp.left = node;
        node.parent = temp; 
                
    }

    @Override
    public void rotateRight(T p) {
        Node<T> node = (Node<T>) p;
        Node<T> temp = node.left;
        node.left = temp.right;
        if (temp.right != null) {
            temp.right.parent = node;
        }
        temp.parent = node.parent;
        if (node.parent == null) {
            root = (Node<E>) temp;
        } else if (node == node.parent.right) {
            node.parent.right = temp;
        } else {
            node.parent.left = temp;
        }
        temp.right = node;
        node.parent = temp;
    }
    
}
