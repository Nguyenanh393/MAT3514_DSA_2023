package Hw4_21000663_NguyenNgocAnh.practice07;

import java.util.*;

public class QueueUsingTwoStacks {
    class StackQueue {
        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        void Push(int x) {
            s1.push(x);
        }

        int Pop() {
            if (s1.isEmpty() && s2.isEmpty()) {
                return -1;
            }
            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }
    }
}
