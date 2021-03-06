package leetcode;

import java.util.*;

/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:

[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Prob46_medium {

    private static class ValueWithRest{
        public int value;
        public int[] rest;

        public ValueWithRest(int value, int[] rest) {
            this.value = value;
            this.rest = rest;
        }
    }

    private List<List<Integer>> permute(List<Integer> currentPermutation, int[] remaining){
        if(remaining.length==1){
            currentPermutation.add(remaining[0]);
            return Collections.singletonList(currentPermutation);
        }else{
            List<ValueWithRest> mappedValues = new ArrayList<>(remaining.length);

            for(int i=0;i<remaining.length;i++){
                int[] rest = new int[remaining.length-1];
                if(i>0){
                    System.arraycopy(remaining, 0, rest, 0, i);
                }
                if(i<remaining.length-1){
                    System.arraycopy(remaining, i+1, rest, i, (remaining.length - i - 1));
                }
                mappedValues.add(new ValueWithRest(remaining[i], rest));
            }

            List<List<Integer>> collectedPermutations = new ArrayList<>();

            for (ValueWithRest valueWithRest : mappedValues) {
                List<Integer> newPerm = new ArrayList<>(currentPermutation);
                newPerm.add(valueWithRest.value);
                List<List<Integer>> allSubPermutations = permute(newPerm, valueWithRest.rest);
                collectedPermutations.addAll(allSubPermutations);
            }

            return collectedPermutations;
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        return permute(new ArrayList<>(nums.length), nums);
    }


    public static void main(String[] args) {
        Prob46_medium prob = new Prob46_medium();
        List<List<Integer>> res = prob.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
