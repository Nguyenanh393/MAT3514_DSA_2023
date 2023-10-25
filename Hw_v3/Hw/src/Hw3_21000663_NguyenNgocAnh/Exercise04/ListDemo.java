package Hw3_21000663_NguyenNgocAnh.Exercise04;

public interface ListDemo<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
    public int indexOf(T data);
}