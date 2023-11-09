package Hw6_21000663_NguyenNgocAnh.exercise02;

import Hw6_21000663_NguyenNgocAnh.exercise01.Entry;
import Hw6_21000663_NguyenNgocAnh.exercise01.SortedArrayPriorityQueue;

public class MinHeapPriorityQueue<K extends Comparable, E> extends SortedArrayPriorityQueue { 
//     Xây dựng cấu trúc dữ liệu hàng đợi ưu tiên sử dụng heap cài đặt bằng mảng với lược
// đồ như sau:
// 1 public class MinHeapPriorityQueue < K extends Comparable , E > extends
// 2 SortedArrayPriorityQueue {
// 3 ArrEntry <K ,E > heapPQ [];
// 4 // Update methods
// 5 protected void upHeap ()
// 6 protected void downHeap ()
// 7 }

    ArrEntry<K, E>[] heapPQ;
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

    public class ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        public ArrEntry(K k, E e) {
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
        while (i < n / 2) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int child = left;
            if (right < n && heapPQ[right].getKey().compareTo(heapPQ[left].getKey()) < 0) {
                child = right;
            }
            if (heapPQ[i].getKey().compareTo(heapPQ[child].getKey()) <= 0) {
                break;
            }
            swap(i, child);
            i = child;
        }
    }
    private void swap(int i, int j) {
        ArrEntry<K, E> temp = heapPQ[i];
        heapPQ[i] = heapPQ[j];
        heapPQ[j] = temp;
    }
    @Override
    public void insert(Entry entry) {
        if (n == capacity) {
            throw new IllegalStateException("Queue is full");
        }
        heapPQ[n] = new ArrEntry<K, E>((K) entry.getKey(), (E) entry.getValue());
        n++;
        upHeap();
    }
    @Override
    public Entry removeMin() {
        if (isEmpty()) {
            return null;
        }
        Entry<K, E> min = heapPQ[0];
        heapPQ[0] = heapPQ[n - 1];
        n--;
        downHeap();
        return min;
    }
    @Override
    public Entry min() {
        if (isEmpty()) {
            return null;
        }
        return heapPQ[0];
    }


    
}
