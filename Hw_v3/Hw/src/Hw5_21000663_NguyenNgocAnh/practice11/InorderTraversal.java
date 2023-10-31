package Hw5_21000663_NguyenNgocAnh.practice11;

import java.util.ArrayList;

public class InorderTraversal {
    class Node {
        int data;
        Node left, right;
    Node(int item) {
            data = item;
            left = right = null;
        }
    }
    class Solution {
        // Function to return a list containing the inorder traversal of the tree.
        ArrayList<Integer> inOrder(Node root) {
            // Code
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) return res;
            res.addAll(inOrder(root.left));
            res.add(root.data);
            res.addAll(inOrder(root.right));
            return res;
        }
    }
}
