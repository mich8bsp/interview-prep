package leetcode;

import java.util.Arrays;

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
 */
public class Prob283_easy {

    public void moveZeroes(int[] nums) {
        int diff = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                diff++;
                continue;
            }
            if(diff>0){
                nums[i-diff] = nums[i];
            }
        }
        for(int i=nums.length-diff; i<nums.length; i++){
            nums[i]=0;
        }
    }

    public static void main(String[] args) {
        Prob283_easy prob = new Prob283_easy();
        int[] nums =new int[] {0, 1, 0, 3, 12};
        prob.moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); //[1, 3, 12, 0, 0]
    }
}
