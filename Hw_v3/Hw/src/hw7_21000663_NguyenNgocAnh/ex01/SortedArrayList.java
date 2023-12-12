package hw7_21000663_NguyenNgocAnh.ex01;

import java.util.*;

public class SortedArrayList<T> implements ListDemo<T> {
    private T[] array; 
    private int n = 0; 

    
    public SortedArrayList() {
        
        int defaultSize = 100;
        array = (T[]) new Object[defaultSize];
    }

    
    public SortedArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    
    public void add(T data) {
        if (n == array.length) { 
            T[] temp = (T[]) new Object[array.length * 2]; 
            
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp; 
        }

        for (int i = 0; i < n; i++) {
            if (((Comparable<T>) data).compareTo(array[i]) < 0) {
                for (int j = n; j > i; j--) {
                    array[j] = array[j - 1];
                }
                array[i] = data;
                n++;
                return;
            }
        }
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
        if (i < n) {
            return i; 
        } else {
            return -1; 
        }
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

    
    public int indexOf(T data) {
        int i = 0; 
        while (i < n && !array[i].equals(data)) { 
            
            i++;
        }
        if (i < n) {
            return i; 
        } else {
            return -1; 
        }
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int i = 0; 

            @Override
            public boolean hasNext() {
                return i < n;
            }

            @Override
            public T next() {
                return array[i++];
            }
        };
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < n; i++) {
            str += array[i];
            if (i < n - 1) {
                str += ", ";
            }
        }
        str += "]";
        return str;
    }

}
