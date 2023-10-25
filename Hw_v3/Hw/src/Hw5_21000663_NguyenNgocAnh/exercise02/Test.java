package Hw5_21000663_NguyenNgocAnh.exercise02;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

public class Test {
    public static void main(String[] args) {
        ExpressionTree<String, LinkedBinaryTree.Node<String>> tree = new ExpressionTree<>();
        LinkedBinaryTree.Node<String> root = tree.addRoot("+");
        LinkedBinaryTree.Node<String> left = tree.addLeft(root, "*");
        LinkedBinaryTree.Node<String> right = tree.addRight(root, "-");
        LinkedBinaryTree.Node<String> left2 = tree.addLeft(left, "3");
        LinkedBinaryTree.Node<String> right2 = tree.addRight(left, "2");
        LinkedBinaryTree.Node<String> left3 = tree.addLeft(right, "5");
        LinkedBinaryTree.Node<String> right3 = tree.addRight(right, "9");

        System.out.println("Preorder: ");
        tree.preorderPrint(root);
        System.out.println("\nPostorder: ");
        tree.postorderPrint(root);
        System.out.println("\nInorder: ");
        tree.inorderPrint(root);
    }
}
