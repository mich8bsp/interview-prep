package ctci.arraysstrings;

/** replace letter repetitions in a string with a single letter followed by the number of repetitions
 *
 */
public class Q1_6_Compressor {

    public static void main(String[] args) {
        Q1_6_Compressor compressor = new Q1_6_Compressor();

        System.out.println(compressor.compress("aabcccccaaa")); //a2b1c5a3
    }

    private String compress(String str) {
        StringBuilder builder = new StringBuilder();

        char lastChar = 0;
        int streakCounter = 0;
        for(char c : str.toCharArray()){
            if(lastChar==0){
                lastChar = c;
                streakCounter++;
            }else{
                if(c==lastChar){
                    streakCounter++;
                }else{
                    builder.append(lastChar).append(streakCounter);
                    lastChar = c;
                    streakCounter=1;
                }
            }
        }
        if(lastChar!=0){
            builder.append(lastChar).append(streakCounter);
        }
        if(builder.length()>=str.length()){
            return str;
        }
        return builder.toString();
    }
}
