package ctci.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class Q1_4_isPermOfPalindrome {

    public static boolean isPermOfPalindrome(String str){
        str = str.toLowerCase().replaceAll(" ", "");
        //its a permutation of a palindrome if every letter appears an even number of times except for one letter which is in the middle
        //unless there is an even number of letters, so every letter appears an even number
        Map<Character, Integer> letterToNumOfInstances = new HashMap<>();
        for(char c : str.toCharArray()){
            letterToNumOfInstances.putIfAbsent(c, 0);
            letterToNumOfInstances.computeIfPresent(c, (oldC, oldCount) -> oldCount+1);
        }

        if(str.length()%2 == 0){
            return letterToNumOfInstances.values()
                    .stream()
                    .allMatch(count -> count%2 == 0);
        }else{
            return letterToNumOfInstances.values()
                    .stream()
                    .filter(x-> x%2 !=0)
                    .count() == 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPermOfPalindrome("Tact Coa"));
        System.out.println(isPermOfPalindrome("abs"));
    }
}
