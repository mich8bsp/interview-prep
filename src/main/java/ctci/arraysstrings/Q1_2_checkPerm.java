package ctci.arraysstrings;

import java.util.HashMap;
import java.util.Map;

public class Q1_2_checkPerm {

    public static boolean isPermutation(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        Map<Character, Integer> counters = new HashMap<>();
        for(char c : str1.toCharArray()){
            counters.putIfAbsent(c, 0);
            counters.computeIfPresent(c, (existingChar, existingCount) -> existingCount+1);
        }
        for(char c : str2.toCharArray()){
            Integer existingCount = counters.get(c);
            if(existingCount==null || existingCount==0){
                return false;
            }
            counters.put(c, existingCount-1);
        }
        return counters.values().stream().allMatch(c -> c==0);
    }

    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "cba")); //true
        System.out.println(isPermutation("abc", "cb")); //false
        System.out.println(isPermutation("abc", "cbad")); //false
        System.out.println(isPermutation("abc", "d")); //false
        System.out.println(isPermutation("abc", "def")); //false
    }
}
