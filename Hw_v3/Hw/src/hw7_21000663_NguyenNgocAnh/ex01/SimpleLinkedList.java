package hw7_21000663_NguyenNgocAnh.ex01;

import java.util.*;

public class SimpleLinkedList <T> implements ListDemo <T> {
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    public void add (T data) {
        Node node = new Node (); 
        node.data = data;
        node.next = null; 
        if (top == null) {
            top = node; 
        } else {
            bot.next = node; 
        }
        bot = node; 
        n++; 
    }

    
    public void addBot (T data) {
        Node newestNode = new Node(); 
        newestNode.data = data; 
        newestNode.next = null; 
        if (top == null) { 
            top = newestNode;  
        } else {
            bot.next = newestNode; 
        }
        bot = newestNode; 
        n++; 
    }


    public T get (int i) {
        Node node = top; 
        for (int j = 0; j < i; j++) { 
            node = node.next;
        }
        return node.data; 
    }

    
    public void set (int i , T data) {
        Node node = top;
        for (int j = 0; j < i; j++) { 
            node = node.next; 
        }
        node.data = data; 
    }

    
    public boolean isContain (T data) { 
        Node node = top; 
        while (node != null) { 
            if (node.data.equals(data)) { 
                return true;
            }
            node = node.next; 
        }
        return false; 
    }


    public int size () { 
        return n; 
    }


    public boolean isEmpty () { 
        return n == 0; 
    }


    public T removeTop () {
        if (top == null) { 
            return null;
        } else {
            T data = top.data; 
            top = top.next; 
            n--; 
            return data; 
        }
    }

    
    public T removeBot () { 
        if (bot == null) { 
            return null;
        } else {
            T data = bot.data; 
            Node node = top; 
            while (node.next != bot) { 
                node = node.next; 
            }
            node.next = null; 
            bot = node; 
            n--; 
            return data; 
        }
    }
    public void remove (T data) {
        Node node = top;
        Node temp = null; 
        while (node != null) {
            if (node.data.equals(data)) { 
                if (temp == null) {
                    top = node.next; 
                } else { 
                    temp.next = node.next;
                }
                n--; 
                break;
            }
            temp = node; 
            node = node.next;
        }
    }

    public int search (T data) {
        Node node = top; 
        int i = 0; 
        while (node != null) { 
            if (node.data.equals(data)) { 
                break; 
            }
            node = node.next; 
            i++; 
        }
        return i;
    }

    public String toString () {
        String str = "[";
        Node node = top;
        while (node != null) {
            str += node.data;
            if (node.next != null) {
                str += ", ";
            }
            node = node.next;
        }
        str += "]";
        return str;
    }


    public Iterator<T> iterator () {
        return new Iterator<>() {
            private Node node = top;

            public boolean hasNext () {
                return node != null;
            }

            public T next () {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T data = node.data;
                node = node.next;
                return data;
            }
        };
    }

    @Override
    public int indexOf(T data) {
        Node node = top;
        int i = 0;
        while (node != null) {
            if (node.data.equals(data)) {
                return i;
            }
            node = node.next;
            i++;
        }
        return -1;
    }

}