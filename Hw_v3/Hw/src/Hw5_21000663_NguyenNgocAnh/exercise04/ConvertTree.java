package Hw5_21000663_NguyenNgocAnh.exercise04;

import java.util.ArrayList;

public class ConvertTree<E> {

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        private ArrayList<Node<E>> child;
    
        public Node(E e, Node<E> above, ArrayList<Node<E>> children) {
            element = e;
            parent = above;
            child = children != null ? children : new ArrayList<>();
        }

        public String getElement() {
            if (element == null) {
                return "null";
            }
            return element.toString();
        }
    }
    
    public Node<E> root = null;

    public Node<E> addRoot(E element) {
        if (root != null) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(element, null, null);
        return root;
    }

    public Node<E> addChild(Node<E> p, E element) {
        Node<E> child = new Node<>(element, p, new ArrayList<>());
        p.child.add(child);
        return child;
    }

    public void convert(Node<E> p) {
        if (p == null || p.parent == null) { // check if p is root
            return;
        }

        // remove p from p.parent.child -> remove p.parent
        // -> add p.parent to p.child
        // -> convert(p.parent) -> root = p
        Node<E> parent = p.parent;
        parent.child.remove(p);
        p.parent = null;
        p.child.add(parent);
        convert(parent);
        root = p;
    }

    private void printTree(Node<E> p, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
        System.out.println(p.getElement());
        for (Node<E> child : p.child) {
            printTree(child, level + 1);
        }
    }

    public void printTree(Node<E> p) {
        printTree(p, 0);
    }
}
