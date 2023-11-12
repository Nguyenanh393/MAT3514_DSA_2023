package Hw6_21000663_NguyenNgocAnh.exercise01;

public class SortedLinkPriorityQueue<K extends Comparable, E> implements PriotityQueueInterface { 
    protected class NodeEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        private NodeEntry<K, E> next;
        public NodeEntry(K k, E e) {
            key = k;
            element = e;
        }
        @Override
        public K getKey() {
            if (key == null) {
                throw new NullPointerException("Null key"); 
            }
            return key;
        }
        @Override
        public E getValue() {
            if (element == null) {
                throw new NullPointerException("Null element"); 
            }
            return element;
        }
    }
    
    private NodeEntry<K, E> head;
    private NodeEntry<K, E> tail;
    int n = 0;

    public SortedLinkPriorityQueue() {
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return n;
    }
    @Override
    public boolean isEmpty() {
        return n ==0;
    }
    @Override
    public void insert(Entry entry) {
        if (n == 0) {
            head = new NodeEntry<K, E>((K) entry.getKey(), (E) entry.getValue());
            tail = head;
        } else {
            NodeEntry<K, E> newNode = new NodeEntry<K, E>((K) entry.getKey(), (E) entry.getValue());
            NodeEntry<K, E> current = head;
            NodeEntry<K, E> previous = null;
            while (current != null && current.getKey().compareTo((K) entry.getKey()) < 0) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                previous.next = newNode;
            }
        }
        n++;
    }
    @Override
    public void insert(Object k, Object e) {
        if (n == 0) {
            head = new NodeEntry<K, E>((K) k, (E) e);
            tail = head;
        } else {
            NodeEntry<K, E> newNode = new NodeEntry<K, E>((K) k, (E) e);
            NodeEntry<K, E> current = head;
            NodeEntry<K, E> previous = null;
            while (current != null && current.getKey().compareTo((K) k) < 0) {
                previous = current;
                current = current.next;
            }
            if (previous == null) {
                newNode.next = head;
                head = newNode;
            } else {
                newNode.next = current;
                previous.next = newNode;
            }
        }
        n++;
}


    @Override
    public Entry removeMin() {
        head = head.next;  
        n--;
        return head; 
    }

    @Override
    public Entry min() {
        return head;
    }

    public void print() {
        NodeEntry<K, E> current = head;
        while (current != null) {
            System.out.println(current.getKey() + " " + current.getValue());
            current = current.next;
        }
    }
}