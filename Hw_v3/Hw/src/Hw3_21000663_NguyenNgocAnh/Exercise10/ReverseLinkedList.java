package Hw3_21000663_NguyenNgocAnh.Exercise10;

public class ReverseLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    class Solution {
        public void reverseList(Node head) {
            Node prev = null;
            Node curr = head;
            Node next = null;

            while (curr != null) {
                next = curr.next; // save next node
                curr.next = prev; // reverse pointer
                prev = curr; // move prev to curr
                curr = next; // move curr to next
            }

            head = prev;
        }
    }
}
