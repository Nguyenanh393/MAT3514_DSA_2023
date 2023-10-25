package Hw4_21000663_NguyenNgocAnh.exercise02;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();

        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
            linkedListStack.push(i);
            System.out.println("______________________");
            System.out.println("ArrayStack: " + arrayStack);
            System.out.println("LinkedListStack: " + linkedListStack);
        }
        linkedListStack.pop();
        System.out.println("______________________");
        System.out.println("linked list stack after pop: " + linkedListStack);

        System.out.println("______________________");
        System.out.println("linked list top " + linkedListStack.top());

        linkedListStack.push(10);
        System.out.println("______________________");
        System.out.println("linked list stack after push: " + linkedListStack);
    }

    Stack<Integer> stack = new Stack<>();

}

// ArrayStack: [0]
// LinkedListStack: [0]
// ______________________
// ArrayStack: [1, 0]
// LinkedListStack: [1, 0]
// ______________________
// ArrayStack: [2, 1, 0]
// LinkedListStack: [2, 1, 0]
// ______________________
// ArrayStack: [3, 2, 1, 0]
// LinkedListStack: [3, 2, 1, 0]
// ______________________
// ArrayStack: [4, 3, 2, 1, 0]
// LinkedListStack: [4, 3, 2, 1, 0]
// ______________________
// ArrayStack: [5, 4, 3, 2, 1, 0]
// LinkedListStack: [5, 4, 3, 2, 1, 0]
// ______________________
// ArrayStack: [6, 5, 4, 3, 2, 1, 0]
// LinkedListStack: [6, 5, 4, 3, 2, 1, 0]
// ______________________
// ArrayStack: [7, 6, 5, 4, 3, 2, 1, 0]
// LinkedListStack: [7, 6, 5, 4, 3, 2, 1, 0]
// ______________________
// ArrayStack: [8, 7, 6, 5, 4, 3, 2, 1, 0]
// LinkedListStack: [8, 7, 6, 5, 4, 3, 2, 1, 0]
// ______________________
// ArrayStack: [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
// LinkedListStack: [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
// ______________________
// linked list stack after pop: [8, 7, 6, 5, 4, 3, 2, 1, 0]
// ______________________
// linked list top 8
// ______________________
// linked list stack after push: [10, 8, 7, 6, 5, 4, 3, 2, 1, 0]
