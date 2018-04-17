package ctci.arraysstrings;

/**
 *  Check if one string is a rotation of a second string (for example, "abcde" and "cdeab")
 */
public class Q1_9_StringRotation {

    public static boolean isSubstring(String str, String subStringCandidate){
        return str.contains(subStringCandidate);
    }

    //if we double str2 we get its end coming full circle with the beginning of the second string and we are guaranteed to have all rotations
    public static boolean isRotation(String str1, String str2){
        if(str1.length()!=str2.length()){
            return false;
        }
        return isSubstring(str2 + str2, str1 );
    }

    public static void main(String[] args) {
        System.out.println(isRotation("waterbottle", "erbottlewat")); // true
        System.out.println(isRotation("waterbottle", "erbottleawat")); // false
        System.out.println(isRotation("waterbottle", "erbottlwat")); // false
    }
}
