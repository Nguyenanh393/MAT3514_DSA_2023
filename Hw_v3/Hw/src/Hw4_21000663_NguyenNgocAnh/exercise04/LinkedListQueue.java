package Hw4_21000663_NguyenNgocAnh.exercise04;

import java.util.*;

public class LinkedListQueue<E> implements QueueInterface<E>{
    class Node {
        E element;
        Node next;
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    @Override
    public void enqueue(E element) {
        Node curr = new Node(); // create a new node
        curr.element = element; // set the element of the new node
        curr.next = null; // set the next of the new node
        if (isEmpty()) {
            head = curr;
            tail = curr;
        } else {
            tail.next = curr; // set the next of the tail to the new node
            tail = curr; // set the tail to the new node
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) return null;
        E dequeueVal = head.element;
        head = head.next;
        size--;
        return dequeueVal;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node curr = head; // start from the head

            @Override
            public boolean hasNext() {
                return curr != null; // check if the queue has next element
            }

            @Override
            public E next() {
                E answer = curr.element; 
                curr = curr.next;
                return answer;
            }
        };
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node curr = head; curr != null; curr = curr.next) {
            sb.append(curr.element);
            if (curr.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
