package hw7_21000663_NguyenNgocAnh.ex01;

public class Test {
    public static void main(String[] args) {
        ListDemo<Integer> unsortedArr = new SimpleArrayList<>();
        unsortedArr.add(1);
        unsortedArr.add(2);
        unsortedArr.add(5);
        unsortedArr.add(3);
        unsortedArr.add(4);
        
        System.out.println(unsortedArr.search(3));

        System.out.println("__________________________");

        ListDemo<Integer> sortedArr = new SortedArrayList<>();
        sortedArr.add(1);
        sortedArr.add(2);
        sortedArr.add(5);
        sortedArr.add(3);
        sortedArr.add(4);

        System.out.println(sortedArr.search(7));

        System.out.println("__________________________");

        ListDemo<Integer> unsortedList = new SimpleLinkedList<>();
        unsortedList.add(1);
        unsortedList.add(2);
        unsortedList.add(5);
        unsortedList.add(3);
        unsortedList.add(4);

        System.out.println(unsortedList.search(4));

        System.out.println("__________________________");

        ListDemo<Integer> sortedList = new SortedLinkedList<>();
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(5);
        sortedList.add(3);
        sortedList.add(4);

        System.out.println(sortedList.search(0));
    }
}
