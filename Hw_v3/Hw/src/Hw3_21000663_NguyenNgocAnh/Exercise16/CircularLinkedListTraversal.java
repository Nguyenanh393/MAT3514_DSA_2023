package Hw3_21000663_NguyenNgocAnh.Exercise16;

public class CircularLinkedListTraversal {
    class Node {
        int data;
        Node next;
        Node(int x) { 
            data = x; 
            next = null; 
        }
    }

    class Solution {
        void printList(Node head) {
            if (head == null) return;
            Node curr = head;
            do {
                System.out.print(curr.data + " ");
                curr = curr.next;
            } while (curr != head);
        }
    }
}
