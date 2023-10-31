package Hw5_21000663_NguyenNgocAnh.practice02;

public class HeightOfBinaryTree {
    class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right = null;
        }
    }
    
    class Solution {
        //Function to find the height of a binary tree.
        int height(Node node) {
            // code here
            if (node == null) return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }
    }

    public static void main(String[] args) {
        HeightOfBinaryTree heightOfBinaryTree = new HeightOfBinaryTree();
        Solution solution = heightOfBinaryTree.new Solution();
        Node root = heightOfBinaryTree.new Node(1);
        root.left = heightOfBinaryTree.new Node(2);
        root.right = heightOfBinaryTree.new Node(3);
        root.left.left = heightOfBinaryTree.new Node(4);
        root.left.right = heightOfBinaryTree.new Node(5);
        System.out.println(solution.height(root));
    }
}
