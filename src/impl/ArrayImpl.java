package impl;

import java.util.Arrays;

public class ArrayImpl<T> {
    private Object[] array;
    private int size = 0;


    public ArrayImpl() {
        this(16);
    }

    public ArrayImpl(int initialCapacity) {
        this.array = new Object[initialCapacity];
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T at(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index];
    }

    public void push(T item) {
        insert(size, item);
    }

    private void adjustCapacity() {
        if (size() >= capacity()) {
            array = Arrays.copyOf(array, array.length * 2);
        }
        if(size() <= 0.25 * capacity()){
            array = Arrays.copyOf(array, (int) (array.length * 0.25));
        }
    }

    public void insert(int index, T item) {
        if (index > size()) {
            throw new IndexOutOfBoundsException();
        }
        adjustCapacity();
        if (index < size) {
            System.arraycopy(array, index, array, index + 1, size + 1 - index);
        }
        array[index] = item;
        size++;
    }

    public void prepend(T item) {
        insert(0, item);
    }

    public T pop() {
        return delete(size - 1);
    }

    public T delete(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T popped = (T) array[index];
        if (index < size() - 1) {
            System.arraycopy(array, index + 1, array, index, size + 1 - index);
        }
        array[--size] = null;
        adjustCapacity();
        return popped;
    }

    public void remove(T item) {
        for (int i = 0; i < size(); i++) {
            if (array[i].equals(item)) {
                delete(i);
            }
        }
    }

    public int find(T item){
        for(int i=0;i<size();i++){
            if(array[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

}
