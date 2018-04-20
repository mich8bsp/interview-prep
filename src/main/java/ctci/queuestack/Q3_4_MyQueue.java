package ctci.queuestack;

import java.util.Stack;

//implementing queue with two stacks
public class Q3_4_MyQueue<T> {
    private Stack<T> mainStack = new Stack<>();
    private Stack<T> tempStack = new Stack<>();

    private void ensureItemsInMainStack() {
        if(mainStack.isEmpty() && !tempStack.isEmpty()){
            while(!tempStack.isEmpty()){
                mainStack.push(tempStack.pop());
            }
        }
    }

    private void ensureItemsInTempStack(){
        if(tempStack.isEmpty() && !mainStack.isEmpty()){
            while(!mainStack.isEmpty()){
                tempStack.push(mainStack.pop());
            }
        }
    }

    public void push(T item){
        ensureItemsInMainStack();
        mainStack.push(item);
    }

    private T getTop(boolean shouldPop){
        ensureItemsInTempStack();
        T topItem;
        if(shouldPop) {
            topItem = tempStack.pop();
        }else{
            topItem = tempStack.peek();
        }
        while(!tempStack.isEmpty()){
            mainStack.push(tempStack.pop());
        }
        return topItem;
    }

    public T pop(){
        return getTop(true);
    }

    public T peek(){
        return getTop(false);
    }

    public boolean isEmpty(){
        return mainStack.isEmpty() && tempStack.isEmpty();
    }
}
