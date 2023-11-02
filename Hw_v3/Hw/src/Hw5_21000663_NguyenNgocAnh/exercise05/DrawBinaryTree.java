package Hw5_21000663_NguyenNgocAnh.exercise05;

// like exercise01

public class DrawBinaryTree<E> {
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

    public Node<E> addRoot(E element) {
        if (root != null) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = new Node<>(element, null, null, null);
        return root;
    }

    public Node<E> addLeft(Node<E> p, E element) {
        if (p.left != null) {
            throw new IllegalStateException("p already has a left child");
        }
        Node<E> child = new Node<>(element, p, null, null);
        p.left = child;
        return child;
    }

    public Node<E> addRight(Node<E> p, E element) {
        if (p.right != null) {
            throw new IllegalStateException("p already has a right child");
        }
        Node<E> child = new Node<>(element, p, null, null);
        p.right = child;
        return child;
    }

    private void printTree(Node<E> p, int dep) {
        if (p == null) {
            return;
        }
        printTree(p.right, dep + 1);
        for (int i = 0; i < dep; i++) {
            System.out.print("    ");
        }
        System.out.println(p.getElement());
        printTree(p.left, dep + 1);
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }
        printTree(root, 0);
    }

}
