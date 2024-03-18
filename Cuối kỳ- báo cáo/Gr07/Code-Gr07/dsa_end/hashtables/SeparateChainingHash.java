package dsa_end.hashtables;

import java.util.*;

public class SeparateChainingHash<Key, Value> {

    private class Node {
        private Key key;
        private Value value;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] table;
    private int size;
    private int capacity;
    private int deleted; 

    public SeparateChainingHash(int capacity) {
        this.capacity = capacity;
        this.table = new LinkedList[capacity];
        this.size = 0;
        this.deleted = 0;
    }

    public void insert(Key key, Value value) {
        if (size + deleted == capacity) {
            resize(capacity * 2);
        }
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();  
        }
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value; 
                return;
            }
        }
        table[index].add(new Node(key, value));
        size++;
    }

    public void delete(Key key) {
        int index = hash(key);
        if (table[index] == null) {
            return;
        }
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                table[index].remove(node);
                size--;
                deleted++;
                return;
            }
        }
        if (size + deleted == capacity / 4) { 
            resize(capacity / 2);
        }
    }

    public Value search(Key key) {
        int index = hash(key);
        if (table[index] == null) {
            return null;
        }
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    private int hash(Key key) {
        return key.hashCode() % capacity & 0x7fffffff;
    }

    private void resize(int capacity) {
        LinkedList<Node>[] tempTable = new LinkedList[capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (table[i] != null) {
                for (Node node : table[i]) {
                    int index = hash(node.key);
                    if (tempTable[index] == null) {
                        tempTable[index] = new LinkedList<>();
                    }
                    tempTable[index].add(node);
                }
            }
        }
        this.table = tempTable;
        this.capacity = capacity;
    }

    public void print() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] == null) {
                System.out.print("null ");
                continue;
            }
            for (Node node : table[i]) {
                System.out.print(node.key + " ");
            }
        }
        System.out.println();
    }
}
