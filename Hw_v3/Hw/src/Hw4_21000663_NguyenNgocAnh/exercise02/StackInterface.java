package Hw4_21000663_NguyenNgocAnh.exercise02;

public interface StackInterface<E> extends Iterable<E>{
    public void push(E element);
    public E pop();
    public boolean isEmpty();
    public E top();
}
