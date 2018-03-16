package leetcode;

/*
Write a function that takes a string as input and returns the string reversed.
 */
public class Prob344_easy {
    public String reverseString(String s) {
        if(s==null || s.isEmpty()){
            return s;
        }
        StringBuilder reverse = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }

    public static void main(String[] args) {
        Prob344_easy prob = new Prob344_easy();
        System.out.println(prob.reverseString("hallelujah")); //hajulellah
    }
}
