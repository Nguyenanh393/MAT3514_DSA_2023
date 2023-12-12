package Hw8_21000663_NguyenNgocAnh.practice;
// đã submit
import java.util.*;

public class practice03 {
    class Solution {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[V];
        dfs(0, adj, visited, res);
        return res; 
    }

    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> res) {
        visited[node] = true;
        res.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, res);
            }
        }
    }
}
}
