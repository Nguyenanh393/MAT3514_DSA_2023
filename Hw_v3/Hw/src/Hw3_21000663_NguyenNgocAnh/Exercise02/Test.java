package Hw3_21000663_NguyenNgocAnh.Exercise02;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ListInterface<Integer> list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(15);
        list.add(6);
        System.out.println("list: " + list);
        System.out.println("list.size(): " + list.size());
        System.out.println("list.isEmpty(): " + list.isEmpty());
        System.out.println("list.isContain(3): " + list.isContain(3));
        System.out.println("list.isContain(5): " + list.isContain(5));
        System.out.println("list.get(2): " + list.get(2));
        list.set(2, 5);
        System.out.println("list.set(2, 5): " + list);
        list.remove(5);
        System.out.println("list.remove(5): " + list);
        list.remove(1);
        System.out.println("list.remove(1): " + list);
        list.remove(4);
        System.out.println("list.remove(4): " + list);
        System.out.println("list.size(): " + list.size());
        System.out.println("list.isEmpty(): " + list.isEmpty());
        System.out.println("list.isContain(3): " + list.isContain(3));
        System.out.println("list.isContain(5): " + list.isContain(5));
        System.out.println("list.get(0): " + list.get(0));
        System.out.println("list.iterator(): " + (list.iterator()));
        System.out.print("list.iterator().next(): ");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }
}
//        list: [1, 2, 3, 4, 15, 6]
//        list.size(): 6
//        list.isEmpty(): false
//        list.isContain(3): true
//        list.isContain(5): false
//        list.get(2): 3
//        list.set(2, 5): [1, 2, 5, 4, 15, 6]
//        list.remove(5): [1, 2, 4, 15, 6]
//        list.remove(1): [2, 4, 15, 6]
//        list.remove(4): [2, 15, 6]
//        list.size(): 3
//        list.isEmpty(): false
//        list.isContain(3): false
//        list.isContain(5): false
//        list.get(0): 2
//        list.iterator(): SimpleArrayList$1@3feba861
//        list.iterator().next(): 2 15 6