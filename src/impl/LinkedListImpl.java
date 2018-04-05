package impl;

import java.util.Optional;

public class LinkedListImpl<T> {

    private LinkedListNode root = null;
    private LinkedListNode tail = null;
    private int size = 0;

    private class LinkedListNode {
        private T value;
        private LinkedListNode next;

        public LinkedListNode(T value) {
            this(value, null);
        }

        public LinkedListNode(T value, LinkedListNode next) {
            this.value = value;
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public LinkedListNode getNext() {
            return next;
        }

        public void setNext(LinkedListNode next) {
            this.next = next;
        }
    }

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


    private LinkedListNode nodeAt(int index){
        checkIndex(index);
        LinkedListNode currNode = root;
        for (int i = 0; i < index; i++) {
            if (currNode == null) {
                break;
            }
            currNode = currNode.next;
        }
        return currNode;
    }

    private T valueOf(LinkedListNode node){
        return Optional.ofNullable(node)
                .map(LinkedListNode::getValue)
                .orElse(null);
    }

    public T valueAt(int index) {
        return valueOf(nodeAt(index));
    }

    public void pushFront(T value) {
        root = new LinkedListNode(value, root);
        if (tail == null) {
            tail = root;
        }
        size++;
    }

    public T popFront() {
        if (isEmpty()) {
            return null;
        }
        LinkedListNode oldRoot = root;
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
            tail.setNext(new LinkedListNode(value));
            tail = tail.getNext();
            size++;
        }
    }

    public T popBack() {
        if (size <= 1) {
            return popFront();
        } else {
            LinkedListNode currNode = nodeAt(size-1);
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
        LinkedListNode prevNode = nodeAt(index-1);
        LinkedListNode nextNode = prevNode.getNext();
        LinkedListNode currNode = new LinkedListNode(value, nextNode);
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
        LinkedListNode prevNode = nodeAt(index-1);
        LinkedListNode currNode = prevNode.getNext();
        LinkedListNode nextNode = currNode.getNext();
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
        LinkedListNode prevNode = null;
        LinkedListNode currentNode = root;
        for(int i=0;i<size;i++){
            LinkedListNode nextNode = currentNode.getNext();
            currentNode.setNext(prevNode);
            prevNode = currentNode;
            currentNode = nextNode;
        }
        LinkedListNode temp = root;
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
