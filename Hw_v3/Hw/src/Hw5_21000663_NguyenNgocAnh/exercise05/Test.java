package Hw5_21000663_NguyenNgocAnh.exercise05;

public class Test {
    public static void main(String[] args) {
        DrawBinaryTree<Integer> tree = new DrawBinaryTree<>();
        DrawBinaryTree.Node<Integer> root = tree.addRoot(1);
        DrawBinaryTree.Node<Integer> node2 = tree.addLeft(root, 2);
        DrawBinaryTree.Node<Integer> node3 = tree.addRight(root, 3);
        DrawBinaryTree.Node<Integer> node4 = tree.addLeft(node2, 4);
        DrawBinaryTree.Node<Integer> node5 = tree.addRight(node2, 5);

        tree.printTree();
    }
}

//     3
// 1
//         5
//     2
//         4