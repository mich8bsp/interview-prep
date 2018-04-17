package ctci.arraysstrings;

public class Q1_9_StringRotation {

    public static boolean isSubstring(String str, String subStringCandidate){
        return str.contains(subStringCandidate);
    }

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
