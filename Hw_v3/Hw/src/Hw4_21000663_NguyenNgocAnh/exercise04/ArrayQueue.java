package Hw4_21000663_NguyenNgocAnh.exercise04;

import java.util.*;

public class ArrayQueue<E> implements QueueInterface<E>{
    private E[] queue;
    private int n = 0;
    private int top = 0;
    private int count = 0;
    private int default_size = 100;

    public ArrayQueue(int capacity) {
        n = capacity;
        queue = (E[]) new Object[capacity];
    }

    public ArrayQueue() {
        n = default_size;
        queue = (E[]) new Object[default_size];
    }

    @Override
    public void enqueue(E element) {
        if (count == n) {
            System.out.println("Queue is full");
            return;
        }
        queue[(top + count) % n] = element; // circular array, top = 0 
        count++; // count = 1 -> 2 -> 3 -> ... -> n -> full
    }

    @Override
    public E dequeue() {
        if (count == 0) {
            System.out.println("Queue is empty");
            return null;
        }
        E temp = queue[top]; // top = 0
        top = (top + 1) % n; // top = 1, circular array
        count--; // count = n -> n - 1 -> n - 2 -> ... -> 1 -> 0 -> empty
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    public Iterator<E> iterator() {
        return new Iterator<>() {
            private int i = top;
            private int c = count;
            @Override
            public boolean hasNext() { // check if the queue has next element
                return c > 0;
            }

            @Override
            public E next() { // return the next element
                E temp = queue[i];
                i = (i + 1) % n;
                c--;
                return temp;
            }
        };
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top; i < top + count; i++) {
            sb.append(queue[i % n]);
            if (i < top + count - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
