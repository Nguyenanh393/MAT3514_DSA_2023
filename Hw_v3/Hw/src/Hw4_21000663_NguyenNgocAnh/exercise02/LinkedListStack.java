package Hw4_21000663_NguyenNgocAnh.exercise02;

import java.util.*;

public class LinkedListStack<E> implements StackInterface<E> {

    class Node {
        E element;
        Node next;
    }

    private Node stack = null;
    private int size = 0;

    @Override
    public void push(E element) {
        Node curr = new Node();
        curr.element = element;
        curr.next = stack;
        stack = curr;
        size++;
    }

    @Override
    public E pop() {
        if (isEmpty()) return null;
        E answer = stack.element;
        stack = stack.next;
        size--;
        return answer;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return stack.element;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            private Node curr = stack;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public E next() {
                E answer = curr.element;
                curr = curr.next;
                return answer;
            }
        };
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Node curr = stack; curr != null; curr = curr.next) {
            sb.append(curr.element);
            if (curr.next != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
