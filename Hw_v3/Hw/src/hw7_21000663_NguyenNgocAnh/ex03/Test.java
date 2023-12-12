package hw7_21000663_NguyenNgocAnh.ex03;


import hw7_21000663_NguyenNgocAnh.ex02.LinkedBinaryTree.Node;

public class Test {
    public static void main(String[] args) {
        BalancedTree<Integer, Node<Integer>> tree = new BalancedTree<>();
        Node<Integer> root = null;

        root = tree.insert(4, root);
        tree.insert(2, root);
        tree.insert(6, root);
        tree.insert(1, root);
        tree.insert(3, root);
        tree.insert(5, root);
        tree.insert(7, root);
        tree.insert(8, root);
        tree.insert(9, root);
        tree.insert(0, root);

        tree.printTree();

        System.out.println("--------------------------------");
        tree.rotateLeft(root);

        tree.rotateRight(root);

        tree.printTree();
    }
}
//                                 9
//                         8
//                 7
//         6
//                 5
// 4
//                 3
//         2
//                 1
//                         0
// --------------------------------
//                         9
//                 8
//         7
// 6
//                         5
//                 4
//                         3
//         2
//                 1
//                         0