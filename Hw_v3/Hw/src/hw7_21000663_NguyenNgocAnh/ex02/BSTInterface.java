package hw7_21000663_NguyenNgocAnh.ex02;

public interface BSTInterface<E, T> {
    T findMin();
    T search(E x, T p);
    T insert(E x, T p);
    T delete(E x, T p);
}
