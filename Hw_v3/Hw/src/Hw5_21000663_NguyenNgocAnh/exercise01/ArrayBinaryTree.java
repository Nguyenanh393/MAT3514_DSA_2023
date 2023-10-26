package Hw5_21000663_NguyenNgocAnh.exercise01;

import java.io.*;

public class ArrayBinaryTree<E, T> implements BinaryTreeInterface<T> {
    private E[] array;
    private int n = 0;
    private int defaultSize = 100;

    public ArrayBinaryTree() {
        array = (E[]) new Object[defaultSize];
    }

    public ArrayBinaryTree(int size) {
        array = (E[]) new Object[size];
    }

    public ArrayBinaryTree(E[] array) {
        this.array = array;
        n = array.length;
    }

    public void setRoot(E element) {
        array[1] = element;
        n++;
    }

    public void setLeft(int p, E element) {
        if (2 * p >= array.length) {
            // resize array
            E[] newArray = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[2 * p] = element;
        n++;
    }

    public void setRight(int p, E element) {
        if (2 * p + 1 >= array.length) {
            // resize array
            E[] newArray = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[2 * p + 1] = element;
        n++;
    }

    @Override
    public int root() {
        return 1;
    }
    @Override
    public int size() {
        return n;
    }
    @Override
    public boolean isEmpty() {
        return n == 0;
    }
    @Override
    public int numChildren(T p) {
        int countChild = 0;
        if (2 * (int) p < array.length && array[2 * (int) p] != null) {
            countChild++;
        }
        if (2 * (int) p + 1 < array.length && array[2 * (int) p + 1] != null) {
            countChild++;
        }
        return countChild;
    }


    @Override
    public T parent(T p) {
        if (p == null || p == (T) Integer.valueOf(1)) return null;
        int index = ((Integer) p) / 2;
        return (T) Integer.valueOf(index);
    }

    @Override
    public T left(T p) {
        if (p == null) return null;
        int index = ((Integer) p) * 2;
        if (index >= array.length) return null;
        return (T) Integer.valueOf(index);
    }
    @Override
    public T right(T p) {
        if (p == null) return null;
        int index = ((Integer) p) * 2 + 1;
        if (index >= array.length) return null;
        return (T) Integer.valueOf(index);
    }
    @Override
    public T sibling(T p) {
        if (p == null) return null;
        int index = ((Integer) p);
        if (index % 2 == 0) {
            index++;
        } else {
            index--;
        }
        if (index >= array.length) return null;
        return (T) Integer.valueOf(index);
    }

    public int height() {
        int tempSize = n, count = 0;
        while (tempSize > 0) {
            tempSize /= 2;
            count++;
        }
        return count;
    }

    @Override
    public void printTree() { 
        if (array[1] == null) {
            System.out.println("Tree is empty");
            return;
        }
        printTree((T) Integer.valueOf(1), 1);
    }

    private void printTree(T p, int level) {

        if (array[(Integer) right((T) p)] != null) {
            printTree(right((T) p), level + 1);
        }
        for (int i = 1; i < level; i++) {
            System.out.print("\t");
        }
        System.out.println(array[(int) p]);
        if (array[(Integer) left((T) p)] != null) {
            printTree(left((T) p), level + 1);
        }
    }
        
    @Override
    public void printTreeToFile() {
        // write to file
        try {
            FileWriter fw = new FileWriter("src\\Hw5_21000663_NguyenNgocAnh\\exercise01\\array_tree.txt");
            if (array[1] == null) {
                fw.write("Tree is empty");
                fw.close();
                return;
            }
            printTreeToFile((T) Integer.valueOf(1), 1, fw);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
    }
    
    private void printTreeToFile(T p, int level, FileWriter fw) {
        try {
            if (array[(Integer) right((T) p)] != null) {
                printTreeToFile(right((T) p), level + 1, fw);
            }
            for (int i = 0; i < level; i++) {
                fw.write("\t");
            }
            fw.write(array[(int) p] + "\n");
            if (array[(Integer) left((T) p)] != null) {
                printTreeToFile(left((T) p), level + 1, fw);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}