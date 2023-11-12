package Hw6_21000663_NguyenNgocAnh.exercise02;

import Hw6_21000663_NguyenNgocAnh.exercise01.Entry;

public class Test {
    public static void main(String[] args) {
        MinHeapPriorityQueue<Integer, Integer> minHeapPriorityQueue = new MinHeapPriorityQueue<>(5);
        minHeapPriorityQueue.insert(1, 1);
        minHeapPriorityQueue.insert(2, 0);
        minHeapPriorityQueue.insert(3, 3);
        minHeapPriorityQueue.insert(4, 4);

        // using Entry
        Entry<Integer, Integer> entry = minHeapPriorityQueue.new ArrEntry<>(0, 9);
        minHeapPriorityQueue.insert(entry);


        System.out.println("-----------------");
        Entry<Integer, Integer> entry1 = minHeapPriorityQueue.new ArrEntry<>(7, 2);
        minHeapPriorityQueue.insert(entry1);
        minHeapPriorityQueue.removeMin();
        minHeapPriorityQueue.print();

        System.out.println("-----------------");
        Entry<Integer, Integer> entry2 = minHeapPriorityQueue.new ArrEntry<>(3, 6);
        minHeapPriorityQueue.insert(entry2);
        minHeapPriorityQueue.removeMin();
        minHeapPriorityQueue.print();

        System.out.println("-----------------");
        minHeapPriorityQueue.removeMin();
        minHeapPriorityQueue.print();
    }
}
// -----------------
// 1 1
// 2 0
// 3 3
// 4 4
// 7 2
// -----------------
// 2 0
// 3 6
// 3 3
// 4 4
// 7 2
// -----------------
// 3 6
// 4 4
// 3 3
// 7 2