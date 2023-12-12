package hw7_21000663_NguyenNgocAnh.ex02;
public class BST<E extends Comparable<E>, T> extends LinkedBinaryTree<E , T> implements BSTInterface<E, T> {
    public T findMin() {
        if (root == null) {
            return null;
        }
        Node<E> p = root;
        while (p.left != null) {
            p = p.left;
        }
        return (T) p;
    }

    public T search(E x, T p) {
        if (p == null) {
            return null;
        }
        Node<E> node = (Node<E>) p;
        if (node.element == x) {
            return p;
        }
        if (node.element.compareTo(x) > 0) {
            return search(x, (T) node.left);
        }
        return search(x, (T) node.right);
    }

    public T insert(E x, T p) {
        if (p == null) {
            return (T) addRoot(x);
        }
        Node<E> node = (Node<E>) p;
        if (node.element.compareTo(x) > 0) {
            if (node.left == null) {
                return (T) addLeft(node, x);
            }
            return insert(x, (T) node.left);
        }
        if (node.right == null) {
            return (T) addRight(node, x);
        }
        return insert(x, (T) node.right);
    }

    public T delete(E x, T p) {
        if (p == null) {
            return null;
        }
        Node<E> node = (Node<E>) p;
        if (node.element.compareTo(x) > 0) {
            return delete(x, (T) node.left);
        }
        if (node.element.compareTo(x) < 0) {
            return delete(x, (T) node.right);
        }
        if (node.left == null && node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            return null;
        }
        if (node.left == null) {
            if (node.parent.left == node) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            return (T) node.right;
        }
        if (node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
            return (T) node.left;
        }
        Node<E> n = node.right;
        while (n.left != null) {
            n = n.left;
        }
        node.element = n.element;
        return delete(n.element, (T) n);
    }
}

