package Hw3_21000663_NguyenNgocAnh.Exercise08;

public class NthNodeFromEnd {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        } 
    }

    class Solution {
        int getNthFromLast(Node head, int n) {
            Node temp = head;
            int count = 0;
            while(temp != null) {
                count++;
                temp = temp.next;
            }
            if(count < n) {
                return -1;
            }
            temp = head;
            for(int i = 0; i < count - n; i++) {
                temp = temp.next;
            }
            return temp.data;
        }
    }
}
