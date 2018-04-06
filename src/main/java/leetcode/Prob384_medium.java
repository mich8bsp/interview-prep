package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/*
Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();
 */
public class Prob384_medium {

    private final int[] originalNums;
    private int[] randomShuffleConfig;
    private final Random random = new Random();

    public Prob384_medium(int[] nums) {
        originalNums = nums;
        reset();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        randomShuffleConfig = originalNums;
        return randomShuffleConfig;
    }

    private class MyList{
        private int value;
        private MyList next;
        private MyList prev;

        MyList(int value){
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        void setNext(MyList next){
            this.next = next;
        }

        void setPrev(MyList prev){
            this.prev = prev;
        }

        MyList getNext() {
            return next;
        }

        MyList getPrev() {
            return prev;
        }

        MyList get(int index){
            if(index==0){
                return this;
            }
            return getNext()!=null ? getNext().get(index-1) : null;
        }
    }

    private MyList convertToMyList(int[] nums){
        MyList root = null;
        MyList prev = null;
        for(int num : nums){
            if (root == null) {
                root = new MyList(num);
                prev = root;
            }else{
                MyList current = new MyList(num);
                current.setPrev(prev);
                prev.setNext(current);
                prev = current;
            }
        }
        return root;
    }


    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        MyList currentPermLeft = convertToMyList(randomShuffleConfig);
        int size = randomShuffleConfig.length;
        List<Integer> res = new ArrayList<>(size);
        while(size>0){
            int currentIndex = random.nextInt(size);
            MyList chosenNode = currentPermLeft.get(currentIndex);
            res.add(chosenNode.value);
            if(currentIndex==0){
                if(currentPermLeft.getNext()!=null) {
                    currentPermLeft.getNext().setPrev(null);
                }
                currentPermLeft = currentPermLeft.getNext();
            }else{
                if(chosenNode.getNext()!=null) {
                    chosenNode.getNext().setPrev(chosenNode.getPrev());
                }
                if(chosenNode.getPrev()!=null) {
                    chosenNode.getPrev().setNext(chosenNode.getNext());
                }
            }
            size--;
        }
        randomShuffleConfig = res.stream()
                .mapToInt(x->x)
                .toArray();
        return randomShuffleConfig;
    }

    public static void main(String[] args) {
        Prob384_medium prob = new Prob384_medium(new int[]{1,2,3});

        System.out.println(Arrays.toString(prob.shuffle()));

        System.out.println(Arrays.toString(prob.reset())); // [1, 2, 3]

        System.out.println(Arrays.toString(prob.shuffle()));
    }
}
