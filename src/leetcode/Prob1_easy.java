package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob1_easy {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tempToIndices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            tempToIndices.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer storedTemp = tempToIndices.get(nums[i]);
            if (storedTemp != null && storedTemp != i) {
                return new int[]{i, storedTemp};
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        Prob1_easy prob = new Prob1_easy();
        int[] res = prob.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("Result: " + Arrays.toString(res));
    }
}
