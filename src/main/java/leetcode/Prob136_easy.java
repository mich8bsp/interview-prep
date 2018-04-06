package leetcode;

/*
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Prob136_easy {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }

    public static void main(String[] args) {
        Prob136_easy prob = new Prob136_easy();
        System.out.println(prob.singleNumber(new int[]{1,4,5,2,4,5,1})); //2
        System.out.println(prob.singleNumber(new int[]{1,2,5,2,4,5,1})); //4
    }
}
