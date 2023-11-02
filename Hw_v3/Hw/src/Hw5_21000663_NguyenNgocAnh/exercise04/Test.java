package Hw5_21000663_NguyenNgocAnh.exercise04;

public class Test {
    public static void main(String[] args) {
        ConvertTree<Integer> tree = new ConvertTree<>();
        ConvertTree.Node<Integer> root = tree.addRoot(1);
        ConvertTree.Node<Integer> child1 = tree.addChild(root, 2);
        ConvertTree.Node<Integer> child2 = tree.addChild(root, 3);
        ConvertTree.Node<Integer> child3 = tree.addChild(root, 4);
        ConvertTree.Node<Integer> child4 = tree.addChild(child1, 5);
        
        System.out.println("Before convert:");
        tree.printTree(root);

        tree.convert(child4);        
        //tree.modifyRoot(child4);

        System.out.println("After convert:");
        tree.printTree(tree.root);
    }
}
// Before convert:
// 1
//   2
//     5
//   3
//   4
// After convert:
// 5
//   2
//     1
//       3
//       4