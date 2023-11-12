package Hw6_21000663_NguyenNgocAnh.exercise01;

public class Test {
    public static void main(String[] args) {
        // Viết hàm test các kiểu dữ liệu PriorityQueue đã triển khai với:
        // – Danh sách các số nguyên, giá trị phần tử dùng làm khóa.
        // – Danh sách các đối tượng có khóa và giá trị khác nhau. Ví dụ: đối tượng hàng hóa bao gồm tên hàng
        // hóa (giá trị), giá tiền (khóa)

        // Danh sách các số nguyên, giá trị phần tử dùng làm khóa.
        SortedLinkPriorityQueue<Integer, Integer> sortedLinkPriorityQueue = new SortedLinkPriorityQueue<>();

        Entry<Integer, Integer> entry1 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(1, 1);
        Entry<Integer, Integer> entry2 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(2, 2);
        Entry<Integer, Integer> entry3 = new SortedLinkPriorityQueue<Integer, Integer>().new NodeEntry<Integer, Integer>(3, 3);

        sortedLinkPriorityQueue.insert(entry2);
        sortedLinkPriorityQueue.insert(entry1);
        sortedLinkPriorityQueue.insert(entry3);

        System.out.println("Danh sách các số nguyên, giá trị phần tử dùng làm khóa: ");
        sortedLinkPriorityQueue.print();

        // Danh sách các đối tượng có khóa và giá trị khác nhau. Ví dụ: đối tượng hàng hóa bao gồm tên hàng

        SortedLinkPriorityQueue<String, Integer> sortedLinkPriorityQueue1 = new SortedLinkPriorityQueue<>();

        Entry<Integer, String>entry4 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(1, "A");
        Entry<Integer, String> entry5 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(2, "B");
        Entry<Integer, String> entry6 = new SortedLinkPriorityQueue<Integer, String>().new NodeEntry<Integer, String>(3, "C");

        sortedLinkPriorityQueue1.insert(entry5);
        sortedLinkPriorityQueue1.insert(entry4);
        sortedLinkPriorityQueue1.insert(entry6);

        sortedLinkPriorityQueue1.insert(1, "D");

        System.out.println("Danh sách các đối tượng có khóa và giá trị khác nhau: ");
        sortedLinkPriorityQueue1.print();
        sortedLinkPriorityQueue1.removeMin();
        sortedLinkPriorityQueue1.print();
        System.out.println(sortedLinkPriorityQueue1.min().getValue());
    }
}
