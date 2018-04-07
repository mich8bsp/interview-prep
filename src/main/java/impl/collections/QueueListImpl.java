package impl.collections;

public class QueueListImpl<T> {

    private LinkedListNode<T> root;
    private LinkedListNode<T> tail;
    private int size = 0;


    public void enqueue(T value) {
        LinkedListNode<T> newNode = new LinkedListNode<>(value);
        if (root == null) {
            root = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    public T dequeue() {
        if (root != null) {
            LinkedListNode<T> popped = root;
            root = root.getNext();
            popped.setNext(null);
            if (root == null) {
                tail = null;
            }
            size--;
            return popped.getValue();
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size(){
        return size;
    }

}
