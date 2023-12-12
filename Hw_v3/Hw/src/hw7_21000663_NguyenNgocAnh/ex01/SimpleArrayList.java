package hw7_21000663_NguyenNgocAnh.ex01;

import java.util.*;

public class SimpleArrayList<T> implements ListDemo<T> {
    private T[] array; 
    private int n = 0; 

    
    public SimpleArrayList() {
        
        int defaultSize = 100;
        array = (T[]) new Object[defaultSize];
    }

    
    public SimpleArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    
    public void add(T data) {
        if (n == array.length) { 
            T[] temp = (T[]) new Object[array.length * 2]; 
            
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp; 
        }

        array[n] = data; 
        n++; 
    }

    
    public T get(int i) {
        if (i < 0 || i >= n) { 
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    
    public void set(int i, T data) {
        if (i < 0 || i >= n) { 
            throw new IndexOutOfBoundsException();
        }
        array[i] = data; 
    }

    
    public void remove(T data) {
        int i = 0; 
        while (i < n && !array[i].equals(data)) { 
            
            i++;
        }
        if (isContain(data)) {
            for (int j = i; j < n - 1; j++) {
                array[j] = array[j + 1]; 
            }
            n--; 
        }
    }

    public int search(T data) {
        int i = 0; 
        while (i < n && !array[i].equals(data)) { 
            
            i++;
        }
        return i < n ? i : -1;
    }
    
    public boolean isContain(T data) {
        int i = 0; 
        while (i < n && !array[i].equals(data)) {
            i++;
        }
        return i < n; 
    }
    
    
    public int size() {
        return n;
    }

    
    public boolean isEmpty() {
        return n == 0;
    }

    
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

    @Override
    public int indexOf(T data) {
        int i = 0;
        while (i < n && !array[i].equals(data)) {
            i++;
        }
        return i < n ? i : -1;
    }
}
