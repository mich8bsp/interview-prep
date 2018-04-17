package ctci.arraysstrings;

public class Q1_1_IsUnique {

    //checks whether string has all unique characters
    public static boolean isUnique(String str){
        //trivial - for each character put in hashmap. if it's already there - return false. O(n) runtime, O(n) space
        //under the assumption that string contains only letters, we use bitmap where each index is the distance from 'a'.
        // this gives O(n) runtime and O(1) space
        int asciiBitVector = 0;
        for(char c : str.toCharArray()){
            int currCharIndex = 1 << (c - 'a');
            boolean alreadySet = (asciiBitVector & currCharIndex) > 0;
            if(alreadySet){
                return false;
            }
            asciiBitVector |= currCharIndex;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("abcdrdfs")); //false
        System.out.println(isUnique("abcrdfs")); //true
    }
}
