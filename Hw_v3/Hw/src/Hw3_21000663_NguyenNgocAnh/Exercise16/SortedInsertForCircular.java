package Hw3_21000663_NguyenNgocAnh.Exercise16;

public class SortedInsertForCircular {
    class Node {
        int data;
        Node next;
        Node(int d) { 
            data = d; 
            next = null; 
        }
    }

    class Solution {
        Node sortedInsert(Node head, int data) {
            Node newNode = new Node(data);
            if (head == null) {
                newNode.next = newNode;
                return newNode;
            }
            if (data < head.data) {
                Node curr = head;
                while (curr.next != head) {
                    curr = curr.next;
                }
                curr.next = newNode;
                newNode.next = head;
                return newNode;
            }
            Node curr = head;
            while (curr.next != head && curr.next.data < data) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return head;
        }
    }
}
