package ctci.arraysstrings;

/** Replace all spaces with %20
 *  There is enough additional space in the provided array and the actual length of the string is provided
 */
public class Q1_3_URLify {

    public char[] urlify(char[] str, int length){
        int updatedIndex = str.length-1;
        int originalIndex = length-1;

        while(updatedIndex>0 && originalIndex>0){
            if(str[originalIndex]!=' '){
                str[updatedIndex] = str[originalIndex];
                originalIndex--;
                updatedIndex--;
            }else{
                str[updatedIndex--] = '0';
                str[updatedIndex--] = '2';
                str[updatedIndex--] = '%';
                originalIndex--;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Q1_3_URLify urlifier = new Q1_3_URLify();
        char[] str = "Mr John Smith    ".toCharArray();
        System.out.println(urlifier.urlify(str, 13));
    }
}
