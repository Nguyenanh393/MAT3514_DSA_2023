package Hw3_21000663_NguyenNgocAnh.Exercise06;


class MyLinkedList {
    // Node class
    class Node {
        int val;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }


    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    // get(index)
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    
    // addAtHead(val)
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    // addAtTail(val)
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) { // if list is empty
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        tail.next = newNode; // if list is not empty 
        tail = newNode; // update tail
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) { // if index is invalid
            return;
        }
        if (index == 0) { // if index is 0
            addAtHead(val);
            return;
        } else if (index == size) { // if index is size
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val); // if index is in the middle
        Node curr = head; 
        for (int i = 0; i < index - 1; i++) { // find the node before the index
            curr = curr.next;
        }
        newNode.next = curr.next; // insert the new node
        curr.next = newNode; // update the node before the index
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        if (index == size - 1) {
            tail = curr;
            curr.next = null;
            size--;
            return;
        }
        curr.next = curr.next.next;
        size--;
    }
}
