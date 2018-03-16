package leetcode;

import java.util.Arrays;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class Prob238_medium {
    public int[] productExceptSelf(int[] nums) {
        int[] leftOf = new int[nums.length];
        int[] rightOf = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftOf[i] = 1;
            }else{
                leftOf[i] = leftOf[i-1] * nums[i-1];
            }
        }
        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                rightOf[i] = 1;
            }else{
                rightOf[i] = rightOf[i+1] * nums[i+1];
            }
        }
        int[] output = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            output[i] = leftOf[i] * rightOf[i];
        }
        return output;
    }

    public static void main(String[] args) {
        Prob238_medium prob = new Prob238_medium();

        System.out.println(Arrays.toString(prob.productExceptSelf(new int[]{1,2,3,4}))); //[24, 12, 8, 6]
    }
}
