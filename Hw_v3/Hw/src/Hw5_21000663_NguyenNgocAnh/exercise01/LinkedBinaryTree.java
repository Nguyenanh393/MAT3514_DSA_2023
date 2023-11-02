package Hw5_21000663_NguyenNgocAnh.exercise01;

import java.io.File;
import java.io.FileWriter;

public class LinkedBinaryTree<E, T> implements BinaryTreeInterface<T> {

    public static class Node<E> {
        private E element;
        private Node<E> parent;
        public Node<E> left;
        public Node<E> right;

        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        public String getElement() {
            if (element == null) {
                return "null";
            }
            return element.toString();
        }
    }

    public Node<E> root = null;
    private int size = 0;

    public Node<E> addRoot(E element) {
        // add element to root of an empty tree
        if (root != null) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(element, null, null, null);
        size = 1;
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        // add element to left of p
        if (p.left != null) {
            throw new IllegalStateException("p already has a left child");
        }
        Node<E> child = new Node<>(element, p, null, null);
        p.left = child;
        size++;
        return child;
    }

    public Node<E> addRight(Node<E> p, E element) {
        // add element to right of p
        if (p.right != null) {
            throw new IllegalStateException("p already has a right child");
        }
        Node<E> child = new Node<>(element, p, null, null);
        p.right = child;
        size++;
        return child;
    }

    public void set(Node p, E element) {
        p.element = element;
    }

    @Override
    public T root() {
        return (T) root;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return root == null || size == 0;
    }

    @Override
    public int numChildren(T p) {
        if (p == null) return 0;
        Node<E> node = (Node<E>) p;
        int countChild = 0;
        if (node.left != null) {
            countChild++;
        }
        if (node.right != null) {
            countChild++;
        }
        return countChild;
    }

    @Override
    public T parent(T p) {
        if (p == root) return null;
        Node<E> node = (Node<E>) p;
        return (T) node.parent;
    }

    @Override
    public T left(T p) {
        if (p == null) return null;
        Node<E> node = (Node<E>) p;
        return (T) node.left;
    }

    @Override
    public T right(T p) {
        if (p == null) return null;
        Node<E> node = (Node<E>) p;
        return (T) node.right;
    }

    @Override
    public T sibling(T p) {
        if (p == null) return null;
        Node<E> node = (Node<E>) p;
        if (node.parent == null) {
            return null;
        }
        if (node.parent.left == node) {
            return (T) node.parent.right;
        } else {
            return (T) node.parent.left;
        }
    }

    @Override
    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        printTree((T) root, 0);
    }

    private void printTree(T p, int dep) {
        Node<E> node = (Node<E>) p;
        
        if (right((T) node) != null) {
            printTree(right((T) node), dep + 1);
        }
        for (int i = 0; i < dep; i++) {
            System.out.print("\t");
        }
        System.out.println(node.getElement());
        if (left((T) node) != null) {
            printTree(left((T) node), dep + 1);
        }
    }

    @Override
    public void printTreeToFile() {
        try {
            FileWriter fw = new FileWriter(new File("src/Hw5_21000663_NguyenNgocAnh/exercise01/linked_tree.txt"));
            if (root == null) {
                fw.write("Tree is empty");
                fw.close();
                return;
            }
            printTreeToFile((T) root, 0, fw);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void printTreeToFile(T p, int dep, FileWriter fw) {
        try {
            Node<E> node = (Node<E>) p;
            if (right((T) node) != null) {
                printTreeToFile(right((T) node), dep + 1, fw);
            }
            for (int i = 0; i < dep; i++) {
                fw.write("\t");
            }
            fw.write(node.getElement() + "\n");
            if (left((T) node) != null) {
                printTreeToFile(left((T) node), dep + 1, fw);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
