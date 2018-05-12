package questions;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given a list of denominations (e.g., [1, 2, 5] means you have coins worth $1, $2, and $5) and a target number k,
 * find all possible combinations, if any, of coins in the given denominations that add up to k.
 * You can use coins of the same denomination more than once.
 */
public class CoinDenominations2 {

    private static final List<Integer> denominations = Arrays.asList(1, 2, 5);
    private static Map<AbstractMap.SimpleEntry<Integer, Integer>, List<List<Integer>>> cache = new HashMap<>();

    public static List<List<Integer>> findAllCombinations(int k){
        return findAllCombinations(k, 0);
    }

    public static List<List<Integer>> findAllCombinations(int k, int currentCoinIndex) {
        if (k == 0) {
            List<List<Integer>> currentCombination = new LinkedList<>();
            currentCombination.add(new LinkedList<>());
            return currentCombination;
        }
        if (k <= 0 || currentCoinIndex>=denominations.size()) {
            return null;
        }

        int currentCoin = denominations.get(currentCoinIndex);

        AbstractMap.SimpleEntry<Integer, Integer> key = new AbstractMap.SimpleEntry<>(k, currentCoinIndex);
        if(cache.get(key)!=null){
            return cache.get(key);
        }

        List<List<Integer>> combinationsForNextCoin = findAllCombinations(k, currentCoinIndex+1);
        List<List<Integer>> combinationsWithCurrentCoin = findAllCombinations(k-currentCoin, currentCoinIndex);

        List<List<Integer>> allCombinations = new LinkedList<>();
        if(combinationsForNextCoin!=null){
            allCombinations.addAll(combinationsForNextCoin);
        }
        if(combinationsWithCurrentCoin!=null){
            combinationsWithCurrentCoin = combinationsWithCurrentCoin.stream()
                    .map(LinkedList::new)
                    .peek(x->x.add(currentCoin))
                    .collect(Collectors.toList());
            allCombinations.addAll(combinationsWithCurrentCoin);
        }
        cache.put(key, allCombinations);
        return allCombinations;
    }

    public static void main(String[] args) {
        System.out.println(findAllCombinations(50)
                .stream()
                .map(Object::toString)
        .collect(Collectors.joining("\n")));
    }
}
