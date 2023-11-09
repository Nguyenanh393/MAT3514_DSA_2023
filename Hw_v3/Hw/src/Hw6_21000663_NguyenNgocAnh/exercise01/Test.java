package Hw6_21000663_NguyenNgocAnh.exercise01;

public class Test {
    public static void main(String[] args) {
        UnsortedArrayPriorityQueue<Integer, Integer> unsortedArrayPriorityQueue = new UnsortedArrayPriorityQueue<>(5);
        unsortedArrayPriorityQueue.insert(1, 1);
        unsortedArrayPriorityQueue.insert(2, 2);

        //System.out.println(unsortedArrayPriorityQueue.min().getValue());

        unsortedArrayPriorityQueue.insert(3, 3);
        unsortedArrayPriorityQueue.insert(4, 4);

        // using Entry
        Entry<Integer, Integer> entry = new UnsortedArrayPriorityQueue<>(5).new ArrEntry<>(5, 9);

        unsortedArrayPriorityQueue.insert(entry);

        unsortedArrayPriorityQueue.print();

        System.out.println("-----------------");

        unsortedArrayPriorityQueue.removeMin();

        //unsortedArrayPriorityQueue.print();


        System.out.println("_______________________________");

        SortedArrayPriorityQueue<Integer, Integer> sortedArrayPriorityQueue = new SortedArrayPriorityQueue<>(5);
        sortedArrayPriorityQueue.insert(1, 1);
        sortedArrayPriorityQueue.insert(2, 2);
        sortedArrayPriorityQueue.insert(3, 3);
        sortedArrayPriorityQueue.insert(4, 4);

        // using Entry
        Entry<Integer, Integer> entry2 = new SortedArrayPriorityQueue<>(5).new ArrEntry<>(5, 0);

        sortedArrayPriorityQueue.insert(entry2);

        sortedArrayPriorityQueue.print();

        System.out.println("-----------------");

        sortedArrayPriorityQueue.removeMin();

        sortedArrayPriorityQueue.print();

        System.out.println("_______________________________");

        UnsortedLinkedPriorityQueue<Integer, Integer> unsortedLinkedPriorityQueue = new UnsortedLinkedPriorityQueue<>();
        unsortedLinkedPriorityQueue.insert(1, 1);
        unsortedLinkedPriorityQueue.insert(2, 2);
        unsortedLinkedPriorityQueue.insert(3, 3);
        unsortedLinkedPriorityQueue.insert(4, 4);

        // using Entry
        Entry<Integer, Integer> entry3 = new UnsortedLinkedPriorityQueue<Integer, Integer>().new NodeEntry<>(5, 0);

        unsortedLinkedPriorityQueue.insert(entry3);

        unsortedLinkedPriorityQueue.print();

        System.out.println("-----------------");

        unsortedLinkedPriorityQueue.removeMin();

        unsortedLinkedPriorityQueue.print();

        System.out.println("_______________________________");

        SortedLinkPriorityQueue<Integer, Integer> sortedLinkedPriorityQueue = new SortedLinkPriorityQueue<>();
        sortedLinkedPriorityQueue.insert(1, 1);
        sortedLinkedPriorityQueue.insert(2, 2);
        sortedLinkedPriorityQueue.insert(3, 3);
        sortedLinkedPriorityQueue.insert(4, 4);
        
        // using Entry
        Entry<Integer, Integer> entry4 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<>(5, 0);

        sortedLinkedPriorityQueue.insert(entry4);

        sortedLinkedPriorityQueue.print();

        System.out.println("-----------------");

        sortedLinkedPriorityQueue.removeMin();

        sortedLinkedPriorityQueue.print();

        System.out.println("_______________________________");




    }
}
