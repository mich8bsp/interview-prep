package impl;

public class QueueArrayImpl<T> {

    private Object[] arr;
    private boolean requiresReordering = false;
    private int dequeueIndex = 0;
    private int enqueueIndex = 0;

    public QueueArrayImpl(){
        this(16);
    }

    public QueueArrayImpl(int capacity) {
        arr = new Object[capacity];
    }

    public void enqueue(T value){
        if(isFull()){
            throw new IndexOutOfBoundsException();
        }
        if(requiresReordering && enqueueIndex == arr.length){
            //we've reached the end of the array but we have empty places from the dequeues
            // so we move the contents to beginning of the array - O(1) amortized
            int reorderingSize = size();
            System.arraycopy(arr, dequeueIndex, arr, 0, reorderingSize);
            dequeueIndex=0;
            enqueueIndex = reorderingSize;
            requiresReordering = false;
        }
        arr[enqueueIndex++] = value;
    }

    // runs in O(1)
    public T dequeue(){
        T popped = (T) arr[dequeueIndex];
        arr[dequeueIndex++] = null;
        requiresReordering = true;
        return popped;
    }

    public int size(){
        return enqueueIndex - dequeueIndex;
    }

    public boolean isEmpty(){
        return size()==0;
    }

    public boolean isFull() {
        return size()==arr.length;
    }

}
