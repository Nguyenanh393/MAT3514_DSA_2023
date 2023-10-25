package Hw3_21000663_NguyenNgocAnh.Exercise07;

public class CountNodes {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next= null;
        }
    }

    class Solution {
        public static int getCount(Node head) {
            int count = 0;
            Node current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }
    }
}
