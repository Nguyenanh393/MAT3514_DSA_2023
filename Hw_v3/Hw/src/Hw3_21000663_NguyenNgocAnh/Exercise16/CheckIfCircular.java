package Hw3_21000663_NguyenNgocAnh.Exercise16;

public class CheckIfCircular {
    class Node {
        int data;
        Node next;
        Node(int d) { 
            data = d; 
            next = null; 
        }
    }

    class GfG {
        boolean isCircular(Node head) {
            if (head == null) return true;
            Node curr = head.next;
            while (curr != null && curr != head) {
                curr = curr.next;
            }
            return curr == head;
        }
    }
}
