package Hw6_21000663_NguyenNgocAnh.exercise01;

public class Test {
    public static void main(String[] args) {
        SortedLinkPriorityQueue<Integer, Integer> sortedLinkPriorityQueue = new SortedLinkPriorityQueue<>();

        Entry<Integer, Integer> entry1 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(1, 5);
        Entry<Integer, Integer> entry2 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(2, 4);
        Entry<Integer, Integer> entry3 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(3, 5);

        sortedLinkPriorityQueue.insert(entry2);
        sortedLinkPriorityQueue.insert(entry1);
        sortedLinkPriorityQueue.insert(entry3);
        sortedLinkPriorityQueue.print();

        System.out.println("-----------------");
        SortedLinkPriorityQueue<String, Integer> sortedLinkPriorityQueue1 = new SortedLinkPriorityQueue<>();

        Entry<Integer, String> entry4 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(1, "A");
        Entry<Integer, String> entry5 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(2, "B");
        Entry<Integer, String> entry6 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(3, "C");

        sortedLinkPriorityQueue1.insert(entry5);
        sortedLinkPriorityQueue1.insert(entry4);
        sortedLinkPriorityQueue1.insert(entry6);

        sortedLinkPriorityQueue1.insert(1, "D");
        sortedLinkPriorityQueue1.print();

        System.out.println("-----------------");
        sortedLinkPriorityQueue1.removeMin();
        sortedLinkPriorityQueue1.print();

        System.out.println("-----------------");
        System.out.println(sortedLinkPriorityQueue1.min().getValue());
    }
}
// 1 5
// 2 4
// 3 5
// -----------------
// 1 D
// 1 A
// 2 B
// 3 C
// -----------------
// 1 A
// 2 B
// 3 C
// -----------------
// A