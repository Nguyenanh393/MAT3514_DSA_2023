package Hw3_21000663_NguyenNgocAnh.Exercise16;

public class DeleteAndReverse {
    class Node {
        int data;
        Node next;
        Node(int d) { 
            data = d; 
            next = null; 
        }
    }

    class GfG {
        public static Node deleteNode(Node head, int d) {
            if (head == null) return null;
            if (head.data == d && head.next == head) return null;
            Node curr = head, prev = null;
            while (curr.data != d) {
                if (curr.next == head) return head;
                prev = curr;
                curr = curr.next;
            }
            if (curr == head) {
                prev = head;
                while (prev.next != head) {
                    prev = prev.next;
                }
                head = curr.next;
                prev.next = head;
            } else if (curr.next == head) {
                prev.next = head;
            } else {
                prev.next = curr.next;
            }
            return head;
        }

        public static Node reverse(Node head) {
            if (head == null) return null;
            Node curr = head, prev = null, next = null;
            do {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            } while (curr != head);
            head.next = prev;
            head = prev;
            return head;
        }
    }
}
