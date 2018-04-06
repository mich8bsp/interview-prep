package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */
public class Prob22_medium {

    public void generateWithBalance(int n, int balance, String currentString, List<String> allPermutations){
        if(n==0){
            if(balance>0){
                currentString += IntStream.range(0, balance).boxed().map(x->")").collect(Collectors.joining(""));
            }
            allPermutations.add(currentString);
        }else {
            if (balance == 0) {
                generateWithBalance(n - 1, balance + 1, currentString + "(", allPermutations);
            } else {
                generateWithBalance(n - 1, balance + 1, currentString + "(", allPermutations);
                generateWithBalance(n, balance - 1, currentString + ")", allPermutations);
            }
        }
    }


    public List<String> generateParenthesis(int n) {
        List<String> allPermutations = new LinkedList<>();
        generateWithBalance(n, 0, "", allPermutations);
        return allPermutations;
    }

    public static void main(String[] args) {
        Prob22_medium prob = new Prob22_medium();
        System.out.println(prob.generateParenthesis(3)); // [((())), (()()), (())(), ()(()), ()()()]
    }
}
