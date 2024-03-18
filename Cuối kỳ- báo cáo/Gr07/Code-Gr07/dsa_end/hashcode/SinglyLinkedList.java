package dsa_end.hashcode;

public class SinglyLinkedList {

    class Node {
        private Object element;
        private Node next;

        public Node(Object e, Node n) {
            element = e;
            next = n;
        }
        public Object getElement() {
            return element;
        }
        public Node getNext() {
            return next;
        }
    }

    public void addFirst(Object e) {
        head = new Node(e, head);
        size++;
    }

    Node head = null;
    int size = 0;
    public int hashCode() {
        int h = 0;
    for (Node walk = head; walk != null; walk = walk.getNext()) {
        h ^= walk.getElement().hashCode(); 
        h = (h << 5) | (h >>> 27); 
    }
        return h;
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addFirst("Hello");
        list.addFirst("World");
        System.out.println(list.hashCode()); // 2087247443

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addFirst("Hello");
        list2.addFirst("World");
        System.out.println(list.equals(list2)); // true
        System.out.println(list2.hashCode()); //2087247443

        SinglyLinkedList list3 = new SinglyLinkedList();
        list3.addFirst("World");
        list3.addFirst("Hello");
        System.out.println(list.equals(list3)); // false
        System.out.println(list3.hashCode()); // 124233296
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        SinglyLinkedList other = (SinglyLinkedList) o;
        if (size() != other.size()) {
            return false;
        }
        Node walkA = head;
        Node walkB = other.head;
        while (walkA != null) {
            if (!walkA.getElement().equals(walkB.getElement())) {
                return false;
            }
            walkA = walkA.getNext();
            walkB = walkB.getNext();
        }
        return true;
    }

    private Object size() {
        return size;
    }
}
