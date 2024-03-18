package dsa_end.hashtables;

public class QuadraticProbingHash<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;
    private int capacity;
    private int deleted;

    public QuadraticProbingHash(int capacity) {
        this.capacity = capacity;
        this.keys = (Key[]) new Object[capacity];
        this.values = (Value[]) new Object[capacity];
        this.size = 0;
        this.deleted = 0;
    }

    public void insert(Key key, Value value) {
        if (size + deleted == capacity) {
            resize(capacity * 2);
        }
        int index = hash(key);
        int i = 1;
        while (keys[index] != null) {
            index = (index + i * i) % capacity;
            i++;
        }
        keys[index] = key;
        values[index] = value;
        size++;
    }

    public void delete(Key key) {
        int index = hash(key);
        int i = 1;
        while (keys[index] != key) {
            index = (index + i * i) % capacity;
            i++;
        }
        keys[index] = null;
        values[index] = null;
        size--;
        deleted++;

        if (size + deleted == capacity / 4) {
            resize(capacity / 2);
        }
    }

    public Value search(Key key) {
        int index = hash(key);
        int i = 1;
        while (keys[index] != key && keys[index] != null) {
            index = (index + i * i) % capacity;
            i++;
        }
        return values[index];
    }

    private int hash(Key key) {
        return key.hashCode() % capacity;
    }

    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Object[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];
        for (int i = 0; i < this.capacity; i++) {
            if (keys[i] != null) {
                int index = hash(keys[i]);
                int j = 1;
                while (tempKeys[index] != null) {
                    index = (index + j * j) % capacity;
                    j++;
                }
                tempKeys[index] = keys[i];
                tempValues[index] = values[i];
            }
        }
        this.keys = tempKeys;
        this.values = tempValues;
        this.capacity = capacity;
    }
    
    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(keys[i] + " ");
        }
        System.out.println();
    }
}
