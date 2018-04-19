package ctci.queuestack;

import java.util.EmptyStackException;

public class Q3_2_MinStack {

    private class StackNode{
        /**
         * Definition for singly-linked list.
         **/
        public int val;
        public StackNode next;


        private int min;
        public StackNode(int x) {
            val = x;
            min = x;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min){
            this.min = min;
        }

            @Override
            public String toString() {
                if(next==null){
                    return "" + val + "->null";
                }
                return "" + val + "->" + next.toString();
            }
    }

    private StackNode top;

    public void push(int item){
        StackNode node = new StackNode(item);
        node.next = top;
        top = node;
        if(top.next!=null) {
            top.setMin(Math.min(top.getMin(), top.next.getMin()));
        }
    }

    public int pop(){
        if(top==null){
            throw new EmptyStackException();
        }
        StackNode popped = top;
        top = top.next;
        return popped.val;
    }

    public int min(){
        if(top!=null){
            return top.getMin();
        }else{
            throw new EmptyStackException();
        }
    }

    public int peek(){
        if (top == null){
            throw new EmptyStackException();
        }
        return top.val;
    }
}
