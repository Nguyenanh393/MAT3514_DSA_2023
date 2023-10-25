package Hw4_21000663_NguyenNgocAnh.exercise04;

public interface QueueInterface<E> extends Iterable<E> {
    public void enqueue(E element);
    public E dequeue();
    public boolean isEmpty();
}
