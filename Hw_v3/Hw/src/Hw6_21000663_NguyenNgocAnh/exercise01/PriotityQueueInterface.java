package Hw6_21000663_NguyenNgocAnh.exercise01;

public interface PriotityQueueInterface<K, E> {
    public int size();
    public boolean isEmpty();
    public void insert(Entry<K, E> entry);
    public void insert(K k, E e);
    public Entry<K, E> removeMin();
    public Entry<K, E> min();
}
