package Hw5_21000663_NguyenNgocAnh.exercise02;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree;

public class Test {
    public static void main(String[] args) {
        ExpressionTree<String, LinkedBinaryTree.Node<String>> tree = new ExpressionTree<>();
        LinkedBinaryTree.Node<String> root = tree.addRoot("*");
        LinkedBinaryTree.Node<String> left = tree.addLeft(root, "+");
        LinkedBinaryTree.Node<String> right = tree.addRight(root, "-");
        LinkedBinaryTree.Node<String> left2 = tree.addLeft(left, "/");
        LinkedBinaryTree.Node<String> right2 = tree.addRight(left, "2");
        LinkedBinaryTree.Node<String> left3 = tree.addLeft(right, "7");
        LinkedBinaryTree.Node<String> right3 = tree.addRight(right, "4");
        LinkedBinaryTree.Node<String> left4 = tree.addLeft(left2, "6");
        LinkedBinaryTree.Node<String> right4 = tree.addRight(left2, "3");

        System.out.println("Preorder: ");
        tree.preorderPrint();
        System.out.println("\nPostorder: ");
        tree.postorderPrint();
        System.out.println("\nInorder: ");
        tree.inorderPrint();

        System.out.println("\nResult: " + tree.calculate());
    }
}
