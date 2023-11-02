package Hw6_21000663_NguyenNgocAnh.exercise01;

public class UnsortedLinkedPriorityQueue<K extends Comparable, E> implements PriotityQueueInterface {
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

    public UnsortedLinkedPriorityQueue() {
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
            tail.next = new NodeEntry<K, E>((K) entry.getKey(), (E) entry.getValue());
            tail = tail.next;
        }
    }
    @Override
    public void insert(Object k, Object e) {
        if (n == 0) {
            head = new NodeEntry<K, E>((K) k, (E) e);
            tail = head;
        } else {
            tail.next = new NodeEntry<K, E>((K) k, (E) e);
            tail = tail.next;
        }
    }
    @Override
    public Entry removeMin() {
        if (n == 0) {
            throw new NullPointerException("Empty queue");
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> current = head;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
            }
            current = current.next;
        }
        if (min == head) {
            head = head.next;
        } else {
            current = head;
            while (current.next != min) {
                current = current.next;
            }
            current.next = min.next;
        }
        n--;
        return min;
    }
    @Override
    public Entry min() {
        if (n == 0) {
            throw new NullPointerException("Empty queue");
        }
        NodeEntry<K, E> min = head;
        NodeEntry<K, E> current = head;
        while (current != null) {
            if (current.getKey().compareTo(min.getKey()) < 0) {
                min = current;
            }
            current = current.next;
        }
        return min;
    }
}
