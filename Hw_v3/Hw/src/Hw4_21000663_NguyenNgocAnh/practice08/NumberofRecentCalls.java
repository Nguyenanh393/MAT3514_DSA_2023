package Hw4_21000663_NguyenNgocAnh.practice08;

import java.util.*;

public class NumberofRecentCalls {
    class RecentCounter {
        Queue<Integer> q; 
        public RecentCounter() {
            q = new LinkedList<>();
        }
        
        public int ping(int t) {
            q.add(t);
            while (q.peek() < t - 3000) { // remove the elements that are not in the range
                q.poll();
            }
            return q.size();
        }
    }
    
}
