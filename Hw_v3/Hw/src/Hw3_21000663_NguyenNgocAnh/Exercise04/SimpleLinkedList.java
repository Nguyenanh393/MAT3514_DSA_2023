package Hw3_21000663_NguyenNgocAnh.Exercise04;

import java.util.*;

public class SimpleLinkedList <T> implements ListDemo <T> {
    class Node {
        T data;
        Node next;
    }
    private Node top = null;
    private Node bot = null;
    private int n = 0;

    // add data to the top of the list
    public void add (T data ) {
        Node node = new Node (); // create new node
        node.data = data;
        node.next = null; // set next to null
        if ( top == null ) {
            top = node; // if list is empty, set top to node
        } else {
            bot.next = node; // else set bot.next to node
        }
        bot = node; // set bot to node
        n++; // update size
    }

    // add data to the bottom of the list
    public void addBot ( T data ) {
        Node newestNode = new Node(); // create new node
        newestNode.data = data; // set data
        newestNode.next = null; // set next to null
        if ( top == null ) { // if list is empty, set top to newestNode 
            top = newestNode;  
        } else {
            bot.next = newestNode; // else set bot.next to newestNode
        }
        bot = newestNode; // set bot to newestNode
        n++; // update size
    }

    // get value at index i
    public T get ( int i ) {
        Node node = top; // set node to top
        for ( int j = 0; j < i; j++) { // loop through list
            node = node.next; // set node to node.next
        }
        return node.data; // return node.data
    }

    // set value at index i
    public void set ( int i , T data ) {
        Node node = top; // set node to top
        for ( int j = 0; j < i; j++) { // loop through list 
            node = node.next; // set node to node.next
        }
        node.data = data; // set node.data to data
    }

    // check if list contains data
    public boolean isContain ( T data ) { 
        Node node = top; // set node to top
        while (node != null) { // loop through list
            if (node.data.equals(data)) { // if node.data equals data, return true
                return true;
            }
            node = node.next; // set node to node.next
        }
        return false; // return false if data is not found
    }

    // size
    public int size () { 
        return n; // return size
    }

    // isEmpty
    public boolean isEmpty () { 
        return n == 0; // return true if size is 0
    }

    // remove top
    public T removeTop () {
        if ( top == null ) { // if list is empty, return null
            return null;
        } else {
            T data = top.data; // set data to top.data
            top = top.next; // set top to top.next
            n--; // update size
            return data; // return data is the value of the removed node
        }
    }

    // remove bot
    public T removeBot () { 
        if (bot == null) { // if list is empty, return null
            return null;
        } else {
            T data = bot.data; // set data to bot.data
            Node node = top; // set node to top
            while (node.next != bot) { // loop through list until node.next is bot
                node = node.next; // set node to node.next
            }
            node.next = null; // set node.next to null
            bot = node; // set bot to node
            n--; // update size
            return data; // return data is the value of the removed node
        }
    }
    public void remove ( T data ) {
        Node node = top; // set node to top
        Node temp = null; // set temp to null
        while (node != null) { // loop through list until node is null
            if (node.data.equals(data)) { 
                if (temp == null) { // if temp is null, set top to node.next
                    top = node.next; 
                } else { // else set temp.next to node.next
                    temp.next = node.next;
                }
                n--; // update size
                break; // break out of loop if data is found
            }
            temp = node; // set temp to node
            node = node.next; // set node to node.next
        }
    }
    // toString
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

    // return an iterator
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