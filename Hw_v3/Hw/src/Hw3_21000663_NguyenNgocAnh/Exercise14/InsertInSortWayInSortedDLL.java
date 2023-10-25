package Hw3_21000663_NguyenNgocAnh.Exercise14;

public class InsertInSortWayInSortedDLL {
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

    class GfG {
        Node sortedInsert(Node head, int x) {
            Node curr = head;
            Node newNode = new Node(x);
            if (head == null) return newNode;
            if (head.data > x) { // insert at head
                newNode.next = head;
                head.prev = newNode;
                return newNode;
            }
            while (curr.next != null && curr.next.data < x) curr = curr.next; // traverse to the node to be inserted after
            if (curr.next == null) { // insert at tail
                curr.next = newNode;
                newNode.prev = curr;
            } else { // insert in middle
                newNode.next = curr.next;
                newNode.prev = curr;
                curr.next.prev = newNode;
                curr.next = newNode;
            }
            return head;
        }
    }
}
