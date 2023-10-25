package Hw3_21000663_NguyenNgocAnh.Exercise02;

import java.util.*;

public class SimpleArrayList<T> implements ListInterface<T> {
    private T[] array; // array to store data
    private int n = 0; // number of elements

    // Constructor with default size
    public SimpleArrayList() {
        // default size of the array
        int defaultSize = 100;
        array = (T[]) new Object[defaultSize];
    }

    // Constructor with custom size
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    // add data to the end 
    public void add(T data) {
        if (n == array.length) { // array is full
            T[] temp = (T[]) new Object[array.length * 2]; // create new array. set size = 2 * old size to avoid frequent resizing
            // copy data to new array
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp; // update array
        }

        array[n] = data; // add data to the end idx = n
        n++; // increase the number of elements
    }

    // get data at index i
    public T get(int i) {
        if (i < 0 || i >= n) { // invalid index
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    // set data at index i
    public void set(int i, T data) {
        if (i < 0 || i >= n) { // invalid index
            throw new IndexOutOfBoundsException();
        }
        array[i] = data; // update data at index i
    }

    // remove data
    public void remove(T data) {
        int i = 0; // index of data
        while (i < n && !array[i].equals(data)) { 
            // find index of data. if not found, i = n, if found, i = index of data
            i++;
        }
        if (isContain(data)) {
            for (int j = i; j < n - 1; j++) {
                array[j] = array[j + 1]; // shift data to the left
            }
            n--; // update n
        }
    }

    // check if data is in the list
    public boolean isContain(T data) {
        int i = 0; // like above
        while (i < n && !array[i].equals(data)) {
            i++;
        }
        return i < n; // if i < n, data is in the list => return true, else return false
    }
    
    // return the number of elements
    public int size() {
        return n;
    }

    // check if the list is empty
    public boolean isEmpty() {
        return n == 0;
    }

    // return an iterator
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int i = 0;

            public boolean hasNext() {
                return i < n;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[i++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    // toString
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < n; i++) {
            sb.append(array[i]);
            if (i < n - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
