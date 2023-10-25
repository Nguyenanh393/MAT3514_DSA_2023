package Hw4_21000663_NguyenNgocAnh.practice10;

public class DesignCircularDeque {
    class MyCircularDeque {
        int[] arr;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularDeque(int k) {
            arr = new int[k];
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
        }
        
        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            return true;
        }
        
        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            return true;
        }
        
        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            return true;
        }
        
        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            return true;
        }
        
        public int getFront() {
            return isEmpty() ? -1 : arr[front];
        }
        
        public int getRear() {
            return isEmpty() ? -1 : arr[rear];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
    }
}
