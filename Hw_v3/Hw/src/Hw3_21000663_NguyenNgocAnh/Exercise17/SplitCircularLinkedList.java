package Hw3_21000663_NguyenNgocAnh.Exercise17;

public class SplitCircularLinkedList {
    class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    class circular_LinkedList {
        Node head;
        Node head1, head2;
        int size;
        public circular_LinkedList() {
            head = null;
            size = 0;
        }
        public void addToTheLast(Node node) {
            if (head == null) {
                head = node;
                node.next = head;
            } else {
                Node temp = head;
                while (temp.next != head) temp = temp.next;
                temp.next = node;
                node.next = head;
            }
        }
        public boolean isCircular(circular_LinkedList list) {
            Node temp = list.head;
            if (temp == null) return true;
            while (temp.next != list.head) {
                if (temp.next == null) return false;
                temp = temp.next;
            }
            return true;
        }
        public static void printList(Node head) {
            Node temp = head;
            if (head != null) {
                do {
                    System.out.print(temp.data + " ");
                    temp = temp.next;
                } while (temp != head);
            }
            System.out.println();
        }
    }

    class gfg {
        void splitList(circular_LinkedList list) {
             //DO NOT REMOVE THESE 3 LINES
             Node head=list.head;
             Node head1=null;
             Node head2=null;
             
             //Modify these head1 and head2 here, head is the starting point of our original linked list.    
                Node slow=head;
                Node fast=head;
                while(fast.next!=head && fast.next.next!=head){
                    slow=slow.next;
                    fast=fast.next.next;
                }
                if(fast.next.next==head){
                    fast=fast.next;
                }
                head1=head;
                if(head.next!=head){
                    head2=slow.next;
                }
                fast.next=slow.next;
                slow.next=head;

             
             //DO NOT REMOVE THESE 2 LINES
             list.head1=head1;
             list.head2=head2;
        }
    }
}
