package ctci.arraysstrings;

public class Q1_5_OneAway {

    public static boolean isOneAway(String str1, String str2) {
        if (str1.equals(str2)) {
            return true;
        }
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }
        boolean foundOneChange = false;
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(i)) {
                //so far so good
                i++;
                j++;
                continue;
            }
            //from now on we know there was a change
            if (foundOneChange) {
                //if already had change - return false
                return false;
            }
            foundOneChange = true;
            if(i==str1.length()-1 && j==str2.length()-1){
                //if there was no change and we're at the last char in both strings - it's ok to have one change
                i++;
                j++;
                continue;
            }
            if (i + 1 < str1.length() && j + 1 < str2.length() && str1.charAt(i + 1) == str2.charAt(j + 1)) {
                //replace char, from now on both chars should be identical
                i++;
                j++;
                continue;
            }
            if (i + 1 < str1.length() && str1.charAt(i + 1) == str2.charAt(j)) {
                i++;
                continue;
            }
            if (j + 1 < str2.length() && str2.charAt(j + 1) == str1.charAt(i)) {
                j++;
            }
        }
        return !foundOneChange || i == str1.length() && j == str2.length();
    }

    public static void main(String[] args) {
        System.out.println(isOneAway("ab", "abc"));
        System.out.println(isOneAway("bca", "abc"));

        System.out.println(isOneAway("abc", "aecd"));
    }
}
