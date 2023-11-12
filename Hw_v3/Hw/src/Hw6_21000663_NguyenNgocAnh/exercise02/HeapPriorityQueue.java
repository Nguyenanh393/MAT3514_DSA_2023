package Hw6_21000663_NguyenNgocAnh.exercise02;

public class HeapPriorityQueue<E> {
    private E[] heap;
    private int size = 0;
    int capacity = 100;

    public HeapPriorityQueue() {
        heap = (E[]) new Object[capacity];
    }

    public HeapPriorityQueue(int capacity) {
        heap = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insert(E element) {
        if (size == heap.length) {
            E[] newHeap = (E[]) new Object[heap.length * 2];
            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            heap = newHeap;
        }
        heap[size] = element;
        size++;
        upheap(size - 1);
    }

    public void upheap(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (((Comparable<E>) heap[index]).compareTo(heap[parent]) >= 0) {
                break;
            }
            E temp = heap[index];
            heap[index] = heap[parent];
            heap[parent] = temp;
            index = parent;
        }
    }

    public void downheap(int index) {
        while (index < size / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int min = left;
            if (right < size && ((Comparable<E>) heap[right]).compareTo(heap[left]) < 0) {
                min = right;
            }
            if (((Comparable<E>) heap[index]).compareTo(heap[min]) <= 0) {
                break;
            }
            E temp = heap[index];
            heap[index] = heap[min];
            heap[min] = temp;
            index = min;
        }
    }

    public E removeMin() {
        if (isEmpty()) {
            return null;
        }
        E min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        downheap(0);
        return min;
    }

    public E min() {
        if (isEmpty()) {
            return null;
        }
        return heap[0];
    }
}
