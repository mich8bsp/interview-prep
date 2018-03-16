package leetcode;

/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
 */
public class Prob171_easy {

    public int titleToNumber(String s) {
        int baseLetter = 'A';
        int base = 'Z' - 'A' + 1;
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int num = s.charAt(i);
            sum *= base;
            sum += (num - baseLetter + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Prob171_easy prob = new Prob171_easy();

        System.out.println(prob.titleToNumber("A")); //1
        System.out.println(prob.titleToNumber("B")); //2
        System.out.println(prob.titleToNumber("C")); //3
        System.out.println(prob.titleToNumber("Z")); //26
        System.out.println(prob.titleToNumber("AA")); //27
        System.out.println(prob.titleToNumber("AB")); //28
    }
}
