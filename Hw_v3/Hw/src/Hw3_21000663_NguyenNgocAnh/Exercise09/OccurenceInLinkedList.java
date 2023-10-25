package Hw3_21000663_NguyenNgocAnh.Exercise09;

public class OccurenceInLinkedList {
    class Node {
        int data;
        Node next;
        Node(int key) {
            data = key;
            next = null;
        }
    }

    class Solution {
        public static int count(Node head, int search_for) {
            int count = 0;
            Node temp = head;
            while (temp != null) {
                if (temp.data == search_for) {
                    count++;
                }
                temp = temp.next;
            }
            return count;
        }
    }
}
