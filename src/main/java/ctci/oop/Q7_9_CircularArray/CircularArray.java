package ctci.oop.Q7_9_CircularArray;

import java.util.Arrays;

public class CircularArray<T>{

    private Object[] objArray;
    private int rotationOffset = 0;


    public CircularArray(int size){
        this.objArray = new Object[size];
    }


    public void rotateLeft(int rotations){
        rotationOffset += rotations;
    }

    public void rotateRight(int rotations){
        rotationOffset -= rotations;
    }

    private int applyRotationsToIndex(int idx){
        return Math.floorMod(idx + rotationOffset, objArray.length);
    }

    public void put(int index, T val){
        objArray[applyRotationsToIndex(index)] = val;
    }

    public T get(int index){
        return (T) objArray[applyRotationsToIndex(index)];
    }

    public int size(){
        return objArray.length;
    }

    @Override
    public String toString() {
        Object[] tempArr = new Object[size()];
        for(int i=0;i<size();i++){
            tempArr[i] = objArray[applyRotationsToIndex(i)];
        }
        return Arrays.toString(tempArr);
    }

    public static void main(String[] args) {
        CircularArray<Integer> arr = new CircularArray<>(5);
        for(int i=0;i<arr.size(); i++){
            arr.put(i, i);
        }

        System.out.println(arr); // [0, 1, 2, 3, 4]

        arr.rotateLeft(3);
        //[3, 4, 0, 1, 2]
        System.out.println(arr);
        arr.rotateRight(7);
        //[1, 2, 3, 4, 0]
        System.out.println(arr);


    }
}
