package questions;

import java.util.*;

/**
 * Given some coin denominations and a target value M, return the coins combination with the minimum number of coins.
 * Time complexity: O(MN), where N is the number of distinct type of coins.
 * Space complexity: O(M).
 */
public class CoinCombinations {

    public static final int M = 522;

    private static Map<Integer, Optional<List<Integer>>> cache = new HashMap<>();

    public static List<Integer> calcMinCombinationForSum(int sum, List<Integer> denominations){
        if(sum==0){
            return new LinkedList<>();
        }
        if(sum<0){
            return null;
        }
        if(cache.get(sum)!=null){
            return cache.get(sum).orElse(null);
        }
        Optional<List<Integer>> bestCombination = denominations.stream()
                .map(coin -> {
                    List<Integer> combinationOfSubset = calcMinCombinationForSum(sum - coin, denominations);
                    if(combinationOfSubset!=null) {
                        combinationOfSubset = new LinkedList<>(combinationOfSubset);
                        combinationOfSubset.add(coin);
                    }
                    return combinationOfSubset;
                })
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(List::size));
        cache.put(sum, bestCombination);
        return bestCombination.orElse(null);
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println(calcMinCombinationForSum(M, Arrays.asList(1,2,5,10,50)));
        System.out.println("Calculation took " + (System.currentTimeMillis() - startTime)/1000D + " seconds");
        cache.clear();
    }
}
