package Hw8_21000663_NguyenNgocAnh.practice;
// đã submit
import java.util.*;

public class practice01 {
    class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}
}
