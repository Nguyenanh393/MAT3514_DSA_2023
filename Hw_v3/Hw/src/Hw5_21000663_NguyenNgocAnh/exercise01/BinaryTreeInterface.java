package Hw5_21000663_NguyenNgocAnh.exercise01;

public interface BinaryTreeInterface<T> {
    int root();
    int size();
    boolean isEmpty();
    int numChildren(T p);
    T parent(T p);
    T left(T p);
    T right(T p);
    T sibling(T p); 
    void printTree();
    void printTreeToFile();

}