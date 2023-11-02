package Hw5_21000663_NguyenNgocAnh.practice12;

import java.util.ArrayList;

    public class PreorderTraversal {
        class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    class BinaryTree
    {
        //Function to return a list containing the preorder traversal of the tree.
        static ArrayList<Integer> preorder(Node root)
        {
            ArrayList<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            res.add(root.data);
            res.addAll(preorder(root.left));
            res.addAll(preorder(root.right));
            return res;
        }
    }
}