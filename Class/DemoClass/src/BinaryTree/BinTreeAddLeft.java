public class BinTreeAddLeft<E> {
    class Node {
        E element;
        Node parent;
        Node left;
        Node right;
        Node (E element) {
            this.element = element;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }
    public void addRoot(E e) {
        // them nut goc cho cay rong
        Node root = null;
        if (root == null) {
            Node p = new Node(e);
            root = p;
        }
    }
    public void addLeft(Node p, E e) {
        // them nut con trai cho nut p neu chua co con trai
        if (p.left == null) {
            Node q = new Node(e);
            p.left = q;
            q.parent = p;
        }
    }
    public void addRight(Node p, E e) {
        // them nut con phai cho nut p neu chua co con phai
        if (p.right == null) {
            Node q = new Node(e);
            p.right = q;
            q.parent = p;
        }
    }
    public void set(Node p, E e) {
        // thay doi noi dung nut p
        p.element = e;
    }

    public void attach(Node p, Node T1, Node T2) {
        p.left = T1;
        p.right = T2;
        if (T1 != null) T1.parent = p;
        if (T2 != null) T2.parent = p;

        
    }
}
