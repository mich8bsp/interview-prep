package ctci.dynamicprog;

import java.util.HashMap;
import java.util.Map;

public class Q8_1_TripleStep {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int countWaysToJump(int n){
        if(n==0){
            return 1;
        }
        if(n<0){
            return -1;
        }
        Integer cached = cache.get(n);
        if(cached!=null){
            return cached;
        }
        int waysWithOneStep = countWaysToJump(n-1);
        int waysWithTwoSteps = countWaysToJump(n-2);
        int waysWithThreeSteps = countWaysToJump(n-3);
        int sum = 0;
        sum = waysWithOneStep>=0 ? sum + waysWithOneStep : sum;
        sum = waysWithTwoSteps>=0 ? sum + waysWithTwoSteps : sum;
        sum = waysWithThreeSteps>=0 ? sum + waysWithThreeSteps : sum;
        cache.put(n, sum);
        return sum;
    }

    public static void main(String[] args) {
        int sum = countWaysToJump(150);
        System.out.println(sum);
    }

}
