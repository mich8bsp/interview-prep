package ctci.queuestack;

import java.util.Stack;

public class Q3_5_SortStack {

    public static <T extends Comparable<T>> void sort(Stack<T> stack){
        Stack<T> secondaryStack = new Stack<>();

        while(!stack.isEmpty()){
            //for each item in the main stack, we put it in the secondary stack which is sorted in descending order
            T insertItem = stack.pop();
            int counter = 0;
            //while items in secondary stack are larger, we need to move them aside, so we put them on the main stack
            //and then we need to keep track of how many we pushed so we know to pop them back
            while(!secondaryStack.isEmpty() && secondaryStack.peek().compareTo(insertItem)>0){
                T popped = secondaryStack.pop();
                stack.push(popped);
                counter++;
            }
            secondaryStack.push(insertItem);
            for(int i=0;i<counter;i++){
                secondaryStack.push(stack.pop());
            }
        }

    }
}
