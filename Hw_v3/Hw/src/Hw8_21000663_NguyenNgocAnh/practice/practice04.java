package Hw8_21000663_NguyenNgocAnh.practice;
// đã submit
import java.util.*;

public class practice04 {
    class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int neighbor : adj.get(curr)) {
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        return res;
    }
}
}
