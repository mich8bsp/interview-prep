package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Given a string, find the length of the longest substring without repeating characters.

 */
public class Prob3_medium {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charToLastSeenIndex = new HashMap<>();
        int startOfSequence = 0;
        int maxSubstring = 0;
        for(int i = 0; i< s.length(); i++){
            char currentChar = s.charAt(i);
            Integer indexLastSeen = charToLastSeenIndex.get(currentChar);
            if(indexLastSeen!=null && indexLastSeen>=startOfSequence){
                String currentSubstring = s.substring(startOfSequence, i);
                maxSubstring = Math.max(currentSubstring.length(), maxSubstring);
                startOfSequence = indexLastSeen+1;
            }
            charToLastSeenIndex.put(currentChar, i);
        }
        maxSubstring = Math.max(s.substring(startOfSequence, s.length()).length(), maxSubstring);

        return maxSubstring;
    }

    public static void main(String[] args) {
        Prob3_medium prob = new Prob3_medium();

        System.out.println(prob.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(prob.lengthOfLongestSubstring("bbbbb")); //1
        System.out.println(prob.lengthOfLongestSubstring("pwwkew")); //3
    }
}
