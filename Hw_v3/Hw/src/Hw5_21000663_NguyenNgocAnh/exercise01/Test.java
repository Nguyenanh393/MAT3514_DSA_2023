package Hw5_21000663_NguyenNgocAnh.exercise01;

import Hw5_21000663_NguyenNgocAnh.exercise01.LinkedBinaryTree.Node;

public class Test {
    public static void main(String[] args) {
        ArrayBinaryTree<Integer, Integer> tree = new ArrayBinaryTree<>();
        tree.setRoot(1);
        tree.setLeft(1, 5);
        tree.setRight(1, 8);
        tree.setLeft(2, 4);
        tree.setRight(2, 0);
        tree.setLeft(3, 6);

        tree.printTree();
        tree.printTreeToFile();

        System.out.println("--------------------------------------------------");
        // test LinkedBinaryTree
        LinkedBinaryTree<Integer, Node<Integer>> tree2 = new LinkedBinaryTree<>();
        LinkedBinaryTree.Node<Integer> root = tree2.addRoot(1);
        LinkedBinaryTree.Node<Integer> left = tree2.addLeft(root, 4);
        LinkedBinaryTree.Node<Integer> right = tree2.addRight(root, 6);
        LinkedBinaryTree.Node<Integer> left2 = tree2.addLeft(left, 7);
        LinkedBinaryTree.Node<Integer> right2 = tree2.addRight(left, 8);
        LinkedBinaryTree.Node<Integer> left3 = tree2.addLeft(right, 5);
        LinkedBinaryTree.Node<Integer> left4 = tree2.addLeft(left2, 10);
        
        System.out.println("Root: " + tree2.root());
        System.out.println("Size: " + tree2.size());
        System.out.println("isEmpty: " + tree2.isEmpty());
        System.out.println("numChildren(1): " + tree2.numChildren(root));
        System.out.println("parent(1): " + tree2.parent(root));
        System.out.println("left(1): " + tree2.left(root).getElement());
        System.out.println("right(1): " + tree2.right(root).getElement());
        System.out.println("sibling(1): " + tree2.sibling(right).getElement());
        //print tree
        tree2.printTree();
        tree2.printTreeToFile();
    }
}