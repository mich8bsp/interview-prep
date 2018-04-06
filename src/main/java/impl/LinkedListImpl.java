package impl;

import java.util.Optional;

public class LinkedListImpl<T> {

    private LinkedListNode<T> root = null;
    private LinkedListNode<T> tail = null;
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    private void checkIndex(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }


    private LinkedListNode<T> nodeAt(int index){
        checkIndex(index);
        LinkedListNode<T> currNode = root;
        for (int i = 0; i < index; i++) {
            if (currNode == null) {
                break;
            }
            currNode = currNode.getNext();
        }
        return currNode;
    }

    private T valueOf(LinkedListNode<T> node){
        return Optional.ofNullable(node)
                .map(LinkedListNode::getValue)
                .orElse(null);
    }

    public T valueAt(int index) {
        return valueOf(nodeAt(index));
    }

    public void pushFront(T value) {
        root = new LinkedListNode<>(value, root);
        if (tail == null) {
            tail = root;
        }
        size++;
    }

    public T popFront() {
        if (isEmpty()) {
            return null;
        }
        LinkedListNode<T> oldRoot = root;
        root = oldRoot.getNext();
        if (root == null) {
            tail = null;
        }
        oldRoot.setNext(null);
        size--;
        return oldRoot.getValue();
    }

    public void pushBack(T value) {
        if (root == null) {
            pushFront(value);
        } else {
            tail.setNext(new LinkedListNode<>(value));
            tail = tail.getNext();
            size++;
        }
    }

    public T popBack() {
        if (size <= 1) {
            return popFront();
        } else {
            LinkedListNode<T> currNode = nodeAt(size-1);
            T popped = valueOf(currNode);
            tail = currNode;
            tail.setNext(null);
            size--;
            return popped;
        }
    }

    public T front() {
        return valueOf(root);
    }

    public T back() {
        return valueOf(tail);
    }

    public void insert(int index, T value) {
        if(index!=size) {
            checkIndex(index);
        }
        if (index == 0) {
            pushFront(value);
            return;
        }
        if(index==size){
            pushBack(value);
            return;
        }
        LinkedListNode<T> prevNode = nodeAt(index-1);
        LinkedListNode<T> nextNode = prevNode.getNext();
        LinkedListNode<T> currNode = new LinkedListNode<>(value, nextNode);
        prevNode.setNext(currNode);
        size++;
    }

    public T erase(int index){
        checkIndex(index);
        if(index==0){
            return popFront();
        }
        if(index==size-1){
            return popBack();
        }
        LinkedListNode<T> prevNode = nodeAt(index-1);
        LinkedListNode<T> currNode = prevNode.getNext();
        LinkedListNode<T> nextNode = currNode.getNext();
        prevNode.setNext(nextNode);
        currNode.setNext(null);
        return currNode.getValue();
    }

    public T valueNFromEnd(int n){
        return valueOf(nodeAt(size-n));
    }

    public void reverse(){
        if(size<=1){
            return;
        }
        LinkedListNode<T> prevNode = null;
        LinkedListNode<T> currentNode = root;
        for(int i=0;i<size;i++){
            LinkedListNode<T> nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        LinkedListNode<T> temp = root;
        root = tail;
        tail = temp;
    }

    public void removeValue(T value){
        LinkedListNode currNode = root;
        for(int i=0;i<size;i++){
            if(currNode.getValue().equals(value)){
                erase(i);
                return;
            }
        }
    }

}
