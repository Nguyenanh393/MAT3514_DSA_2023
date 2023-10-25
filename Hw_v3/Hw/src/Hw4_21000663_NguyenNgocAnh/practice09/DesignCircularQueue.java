package Hw4_21000663_NguyenNgocAnh.practice09;

public class DesignCircularQueue {
    class MyCircularQueue {
        int[] queue;
        int front;
        int rear;
        int size;
        int capacity;

        public MyCircularQueue(int k) {
            queue = new int[k];
            front = 0;
            rear = -1;
            size = 0;
            capacity = k;
        }
        
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            rear = (rear + 1) % capacity; // circular array, rear + 1 to the next index
            queue[rear] = value;
            size++;
            return true;
        }
        
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            front = (front + 1) % capacity;
            size--;
            return true;
        }
        
        public int Front() {
            return isEmpty() ? -1 : queue[front];
        }
        
        public int Rear() {
            return isEmpty() ? -1 : queue[rear];
        }
        
        public boolean isEmpty() {
            return size == 0;
        }
        
        public boolean isFull() {
            return size == capacity;
        }
    }
}
