package Hw3_21000663_NguyenNgocAnh.Exercise14;

public class DoublyLinkedListInsertion {
    class Node {
        int data;
        Node prev;
        Node next;
        Node (int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    class GfG {
        void addNode(Node head_ref, int pos, int data) {
            Node newNode = new Node(data);
            Node temp = head_ref;
            int count = 0;
            while (count < pos) {
                temp = temp.next;
                count++;
            }
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next = newNode;
            if (newNode.next != null) {
                newNode.next.prev = newNode;
            }
        } 
    }
}
