package ctci.queuestack;

import java.util.Stack;

public class Q3_3_SetOfStacks<T> {

    private static final int MAX_STACK_SIZE = 16;

    private Stack<Stack<T>> stacks = new Stack<>();

    public T push(T item) {
        Stack<T> latestStack = stacks.peek();
        if (latestStack == null || latestStack.size() == MAX_STACK_SIZE) {
            latestStack = new Stack<>();
            stacks.push(latestStack);
        }
        latestStack.push(item);
        return item;
    }

    public synchronized T pop() {
        Stack<T> latestStack = findLastNonEmpty();
        if (latestStack == null) {
            return null;
        }
        T popped = latestStack.pop();
        if(latestStack.isEmpty()){
            stacks.pop();
        }
        return popped;
    }

    private Stack<T> findLastNonEmpty(){
        Stack<T> latestStack = stacks.peek();
        while (latestStack != null && latestStack.isEmpty()) {
            stacks.pop();
            latestStack = stacks.peek();
        }
        return latestStack;
    }

    public boolean empty() {
        return stacks.isEmpty();
    }


    public synchronized T peek() {
        Stack<T> latestStack = findLastNonEmpty();
        if (latestStack == null) {
            return null;
        }
        return latestStack.peek();
    }

}
