package ctci.queuestack;

public class Q3_1_ThreeInOne {

    private static final int NUM_OF_INNER_STACKS = 3;

    private int[] pointers = new int[NUM_OF_INNER_STACKS];
    private Object[] arr;

    public Q3_1_ThreeInOne() {
        this(16);
    }

    public Q3_1_ThreeInOne(int size) {
        this.arr = new Object[size];
        for(int i=0;i<NUM_OF_INNER_STACKS;i++){
            pointers[i] = i;
        }
    }

    public void push(Object item, int stackId) {
        if(stackId>=NUM_OF_INNER_STACKS){
            throw new IllegalArgumentException();
        }
        int pointer = pointers[stackId];
        if(pointer >= arr.length){
            throw new IndexOutOfBoundsException();
        }
        arr[pointer] = item;
        pointers[stackId] = pointer + NUM_OF_INNER_STACKS;
    }

    public Object getTop(int stackId, boolean isPeekOnly){
        if(stackId>=NUM_OF_INNER_STACKS){
            throw new IllegalArgumentException();
        }
        int pointer = pointers[stackId];
        pointer = pointer - NUM_OF_INNER_STACKS;
        if(pointer>0){
            Object ret = arr[pointer];
            if(!isPeekOnly) {
                pointers[stackId] = pointer;
            }
            return ret;
        }else{
            return null;
        }
    }

    public Object peek(int stackId){
        return getTop(stackId, true);
    }

    public Object pop(int stackId){
        return getTop(stackId, false);
    }


}
