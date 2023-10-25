package Hw3_21000663_NguyenNgocAnh.Exercise11;

public class PalindromeLinkedList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    class Solution {
        public boolean isPalindrome(Node head) {
            if (head == null || head.next == null) {
                return true;
            }
            Node slow = head;
            Node fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            Node secondHead = slow.next; 
            slow.next = null;

            Node p1 = secondHead;
            Node p2 = p1.next;

            while (p1 != null && p2 != null) {
                Node temp = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = temp;
            }

            secondHead.next = null;

            Node p = (p2 == null ? p1 : p2);
            Node q = head;
            while (p != null) {
                if (p.data != q.data) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }
    }
}
