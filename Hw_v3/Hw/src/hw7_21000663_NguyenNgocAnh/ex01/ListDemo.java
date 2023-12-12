package hw7_21000663_NguyenNgocAnh.ex01;

public interface ListDemo<T> extends Iterable<T> {
    public void add(T data);
    public T get(int i);
    public void set(int i, T data);
    public void remove(T data);
    public boolean isContain(T data);
    public int size();
    public boolean isEmpty();
    public int indexOf(T data);
    public int search(T data);
}