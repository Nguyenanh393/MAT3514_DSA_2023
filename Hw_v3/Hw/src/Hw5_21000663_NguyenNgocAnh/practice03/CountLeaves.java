package Hw5_21000663_NguyenNgocAnh.practice03;

public class CountLeaves {

class Node
{
    int data;
    Node left, right;
}

class Tree
{
    int countLeaves(Node node) 
    {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1; // leaf
        }
        return countLeaves(node.left) + countLeaves(node.right); 
    }
}

}
