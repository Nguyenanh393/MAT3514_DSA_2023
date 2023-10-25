package Hw3_21000663_NguyenNgocAnh.Exercise14;

public class DeleteNodeInDoublyLinledList {
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int a) {
            data = a;
            next = null;
            prev = null;
        }
    }

    class Solution {
        Node deleteNode(Node head, int x) {
            Node curr = head;
            x--; // x is the position
            while (x > 0 && curr != null) { // traverse to the node to be deleted
                curr = curr.next;
                x--;
            }
            if (curr == null) return head; // x > length
            if (curr == head) { // delete head
                head = head.next;
                return head;
            }
            if (curr.next != null) curr.next.prev = curr.prev; // delete middle node
            if (curr.prev != null) curr.prev.next = curr.next; // delete middle node

            return head;
        }
    }
}
