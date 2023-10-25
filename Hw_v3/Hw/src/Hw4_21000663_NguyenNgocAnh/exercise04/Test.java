package Hw4_21000663_NguyenNgocAnh.exercise04;

public class Test {
    public static void main(String[] args) {
        ArrayQueue<Integer> aq = new ArrayQueue<>();
        LinkedListQueue<Integer> lq = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++) {
            aq.enqueue(i);
            lq.enqueue(i);
        }
        System.out.println("ArrayQueue:" + aq);
        System.out.println("LinkedListQueue:" + lq);
        for (int i = 0; i < 6; i++) {
            aq.dequeue();
            lq.dequeue();
            System.out.println("ArrayQueue:" + aq);
            System.out.println("LinkedListQueue:" + lq);
        }

        System.out.println("ArrayQueue:" + aq);
        System.out.println("LinkedListQueue:" + lq);

    }
}

// ArrayQueue:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// LinkedListQueue:[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
// ArrayQueue:[1, 2, 3, 4, 5, 6, 7, 8, 9]
// LinkedListQueue:[1, 2, 3, 4, 5, 6, 7, 8, 9]
// ArrayQueue:[2, 3, 4, 5, 6, 7, 8, 9]
// LinkedListQueue:[2, 3, 4, 5, 6, 7, 8, 9]
// ArrayQueue:[3, 4, 5, 6, 7, 8, 9]
// LinkedListQueue:[3, 4, 5, 6, 7, 8, 9]
// ArrayQueue:[4, 5, 6, 7, 8, 9]
// LinkedListQueue:[4, 5, 6, 7, 8, 9]
// ArrayQueue:[5, 6, 7, 8, 9]
// LinkedListQueue:[5, 6, 7, 8, 9]
// ArrayQueue:[6, 7, 8, 9]
// LinkedListQueue:[6, 7, 8, 9]
// ArrayQueue:[6, 7, 8, 9]
// LinkedListQueue:[6, 7, 8, 9]