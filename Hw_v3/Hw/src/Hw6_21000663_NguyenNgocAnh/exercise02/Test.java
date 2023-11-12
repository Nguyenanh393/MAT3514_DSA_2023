package Hw6_21000663_NguyenNgocAnh.exercise02;

import Hw6_21000663_NguyenNgocAnh.exercise01.Entry;

public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, Integer> minHeapPriorityQueue = new MinHeapPriorityQueue<>(5);
        minHeapPriorityQueue.insert(1, 1);
        minHeapPriorityQueue.insert(2, 2);
        minHeapPriorityQueue.insert(3, 3);
        minHeapPriorityQueue.insert(4, 4);

        // using Entry
        Entry<Integer, Integer> entry = minHeapPriorityQueue.new ArrEntry<>(5, 9);
        minHeapPriorityQueue.insert(entry);

        minHeapPriorityQueue.print();

        System.out.println("-----------------");

        minHeapPriorityQueue.removeMin();

        //minHeapPriorityQueue.print();
    }
    
}
