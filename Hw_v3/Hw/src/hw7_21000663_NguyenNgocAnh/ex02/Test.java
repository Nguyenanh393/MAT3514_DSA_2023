package hw7_21000663_NguyenNgocAnh.ex02;

import java.io.*;
import java.util.*;

import hw7_21000663_NguyenNgocAnh.ex02.LinkedBinaryTree.Node;

public class Test {
    public static void main(String[] args) {
// So sánh thời gian thực hiện các thuật toán tìm kiếm tuần tự, tìm kiếm nhị phân và tìm kiếm trên cây tìm
// kiếm với tập các số nguyên có kích thước lớn (106, 107, 108).

        // read data from file testcase.txt
        try {
            File file = new File("hw7_21000663_NguyenNgocAnh\\ex02\\data\\testcase.txt");
            Scanner sc = new Scanner(file);
            
            while (sc.hasNextLine()) {
                    int n = Integer.parseInt(sc.nextLine());
                    String[] arr = sc.nextLine().split(" ");
                    int[] a = new int[n];
                    for (int i = 0; i < n; i++) {
                        a[i] = Integer.parseInt(arr[i]);
                    }
                    double[] ssat = new double[20];
                    double[] bsat = new double[20];
                    double[] bstt = new double[20];

                    execute(a, n, ssat, bsat, bstt);
                    try {
                        FileWriter fw = new FileWriter("hw7_21000663_NguyenNgocAnh\\ex02\\data\\result.txt", true);
                        fw.write(n + "\n");

                        fw.write("Sequential Search Algorithm\n");
                        for (int i = 0; i < 20; i++) {
                            fw.write(ssat[i] + " ");
                        }
                        fw.write("\n");

                        fw.write("Binary Search Algorithm\n");
                        for (int i = 0; i < 20; i++) {
                            fw.write(bsat[i] + " ");
                        }
                        fw.write("\n");

                        fw.write("Binary Search Tree Algorithm\n");
                        for (int i = 0; i < 20; i++) {
                            fw.write(bstt[i] + " ");
                        }
                        fw.write("\n");
                        fw.close();
                        System.out.println("Success...");

                    } catch (Exception e) {
                        System.out.println(e);
                    }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void execute(int[] a, int n, double[] ssat, double[] bsat, double[] bstt) {

        // read data from file random_find_element.txt
        int[] b = new int[20];

        if (n == 1000000) {
            try {
                File file = new File("hw7_21000663_NguyenNgocAnh\\ex02\\data\\random_find_element.txt");
                Scanner sc = new Scanner(file);
                sc.nextLine();
                String[] arr = sc.nextLine().split(" ");
                for (int i = 0; i < 20; i++) {
                    b[i] = Integer.parseInt(arr[i]);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                File file = new File("hw7_21000663_NguyenNgocAnh\\ex02\\data\\random_find_element.txt");
                Scanner sc = new Scanner(file);
                sc.nextLine();
                sc.nextLine();
                String[] arr = sc.nextLine().split(" ");
                for (int i = 0; i < 20; i++) {
                    b[i] = Integer.parseInt(arr[i]);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        for (int i = 0; i < 20; i++) {
        SequentialSearchAlgorithm ssa = new SequentialSearchAlgorithm();
        long start = System.nanoTime();
        ssa.sequentialSearch(a, b[i]);
        long end = System.nanoTime();
        ssat[i] = (end - start) / 1000000.0;

        BinarySearchAlgorithm bsa = new BinarySearchAlgorithm();
        start = System.nanoTime();
        bsa.binarySearch(a, b[i]);
        end = System.nanoTime();
        bsat[i] = (end - start) / 1000000.0;

        BST<Integer, Node<Integer>> bst = new BST<>();
        Node<Integer> root = null;
        for (int j = 0; j < n; j++) {
            root = bst.insert(a[j], root);
        }
        start = System.nanoTime();
        bst.search(b[i], root);
        end = System.nanoTime();
        bstt[i] = (end - start) / 1000000.0;

        System.out.println("end " + i + " " + n);
        }
    }
}
