package Hw6_21000663_NguyenNgocAnh.exercise01;

public class SortedArrayPriorityQueue<K extends Comparable, E> implements PriotityQueueInterface{
    public class ArrEntry<K, E> implements Entry<K, E> {
        K key;
        E element;
        public ArrEntry (K k, E e) {
            key = k;
            element = e;
        }
        @Override
        public K getKey() {
            if (key == null) {
                throw new NullPointerException("Null key"); 
            }
            return key;
        }
        @Override
        public E getValue() {
            if (element == null) {
                throw new NullPointerException("Null element"); 
            }
            return element;
        }
    }
    
    ArrEntry<K, E>[] array;
    private int n = 0;
    int defaultSize = 100;

    public SortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public SortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
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
    public void insert(Entry entry) {
        if (n == array.length) {
            ArrEntry<K, E>[] newArray = new ArrEntry[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo((K) entry.getKey()) > 0) {
                for (int j = n; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = (ArrEntry<K, E>) entry;
                n++;
                return;
            }
        }
    }

    @Override
    public void insert(Object k, Object e) {
        if (n == array.length) {
            ArrEntry<K, E>[] newArray = new ArrEntry[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < n; i++) {
            if (array[i].getKey().compareTo((K) k) > 0) {
                for (int j = n; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = new ArrEntry((K) k, (E) e);
                n++;
                return;
            }
        }
    }

    @Override
    public Entry removeMin() {
        if (n == 0) {
            throw new NullPointerException("Empty queue");
        }
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(array[minIndex].getKey()) < 0) {
                minIndex = i;
            }
        }
        Entry<K, E> min = array[minIndex];
        array[minIndex] = array[n - 1];
        array[n - 1] = null;
        n--;
        return min;
    }

    @Override
    public Entry min() {
        if (n == 0) {
            throw new NullPointerException("Empty queue");
        }
        Entry<K, E> min = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i].getKey().compareTo(min.getKey()) < 0) {
                min = array[i];
            }
        }
        return min;
    } 

    public void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(array[i].getKey() + " " + array[i].getValue());
        }
    }
    
}