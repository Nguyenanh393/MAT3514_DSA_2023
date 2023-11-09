package Hw6_21000663_NguyenNgocAnh.exercise01;

public class UnsortedArrayPriorityQueue<K extends Comparable, E> implements PriotityQueueInterface {
    protected class ArrEntry<K, E> implements Entry<K, E> {
        private K key;
        private E element;
        public ArrEntry(K k, E e) {
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
    
    private ArrEntry<K, E>[] array;
    private int n = 0;
    private int defaultSize = 100;

    public UnsortedArrayPriorityQueue() {
        array = new ArrEntry[defaultSize];
    }

    public UnsortedArrayPriorityQueue(int size) {
        array = new ArrEntry[size];
    }

    public UnsortedArrayPriorityQueue(ArrEntry<K, E>[] array) {
        this.array = array;
        n = array.length;
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
        array[n] = (ArrEntry<K, E>) entry;
        n++;
    }

    @Override
    public void insert(Object key, Object value) {
        if (n == array.length) {
            throw new IllegalStateException("Queue is full");
        }

        array[n] = new ArrEntry(key, value);
        n++;
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
