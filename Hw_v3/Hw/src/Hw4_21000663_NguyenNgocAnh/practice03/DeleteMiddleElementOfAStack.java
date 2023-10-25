package Hw4_21000663_NguyenNgocAnh.practice03;

import java.util.*;

public class DeleteMiddleElementOfAStack {
    class Solution {
        public void deleteMid(Stack<Integer> s, int sizeOfStack) {
            int mid = sizeOfStack / 2 + 1;
            delete(s, mid);
        }

        public void delete(Stack<Integer> s, int k) {
            if (k == 1) {
                s.pop();
                return;
            }
            int temp = s.pop();
            delete(s, k - 1); // recursion until k == 1 (reach mid) then pop
            s.push(temp); // push back the popped element
        }
    }
}
