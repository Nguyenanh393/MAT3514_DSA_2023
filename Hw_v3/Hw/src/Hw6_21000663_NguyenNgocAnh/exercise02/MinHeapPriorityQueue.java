package Hw6_21000663_NguyenNgocAnh.exercise02;

import Hw6_21000663_NguyenNgocAnh.exercise01.Entry;
import Hw6_21000663_NguyenNgocAnh.exercise01.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue { 

    ArrEntry[] heapPQ;
    private int capacity = 100;
    private int n = 0;

    public MinHeapPriorityQueue(int capacity) {
        super(capacity);
        heapPQ = new ArrEntry[capacity];
    }
    public MinHeapPriorityQueue() {
        super();
        heapPQ = new ArrEntry[capacity];
    }

    public class ArrEntry<K extends Comparable<K>, E> extends SortedArrayPriorityQueue<K, E>.ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;

        public ArrEntry(K k, E e) {
            super(k, e);
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

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void insert(Entry entry) {
        if (n == heapPQ.length) {
            ArrEntry[] newHeap = new ArrEntry[heapPQ.length * 2];
            for (int i = 0; i < heapPQ.length; i++) {
                newHeap[i] = heapPQ[i];
            }
            heapPQ = newHeap;
        }
        heapPQ[n] = (ArrEntry) entry;
        n++;
        upHeap();
    }

    public void insert(K key, E element) {
        if (n == heapPQ.length) {
            ArrEntry[] newHeap = new ArrEntry[heapPQ.length * 2];
            for (int i = 0; i < heapPQ.length; i++) {
                newHeap[i] = heapPQ[i];
            }
            heapPQ = newHeap;
        }
        heapPQ[n] = new ArrEntry(key, element);
        n++;
        upHeap();
    }

    protected void upHeap() {
        int i = n - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (heapPQ[i].getKey().compareTo(heapPQ[p].getKey()) >= 0) {
                break;
            }
            swap(i, p);
            i = p;
        }
    }

    protected void downHeap() {
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = left;
            if (right < n && heapPQ[right].getKey().compareTo(heapPQ[left].getKey()) < 0) {
                smallest = right;
            }
            if (left >= n || heapPQ[i].getKey().compareTo(heapPQ[smallest].getKey()) <= 0) {
                break;
            }
            swap(i, smallest);
            i = smallest;
        }
    }
    private void swap(int i, int j) {
        ArrEntry temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }

    public Entry<K, E> removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> min = heapPQ[0];
        heapPQ[0] = heapPQ[n - 1];
        downHeap();
        n--;
        return min;
    }

    public Entry<K, E> min() {
        if (isEmpty()) {
            return null;
        }
        return heapPQ[0];
    }

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(heapPQ[i].getKey() + " " + heapPQ[i].getValue());
        }
    }
}
