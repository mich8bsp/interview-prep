package leetcode;

/*
mplement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.



Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 */
public class Prob8_medium {

    public int myAtoi(String str) {
        int res = 0;
        int sign = 1;
        boolean parsedSign = false;
        boolean startedParsingNumber = false;
        for(int i=0;i<str.length();i++){
            char currentChar = str.charAt(i);
            if(currentChar==' '){
                if(parsedSign && !startedParsingNumber){
                    return 0;
                }
                if(startedParsingNumber){
                    return res * sign;
                }
                continue;
            }
            if((currentChar=='-' || currentChar=='+') && !parsedSign && !startedParsingNumber){
                sign*=(currentChar=='-' ? -1 : 1);
                parsedSign = true;
                continue;
            }
            try{
                int num = Integer.parseInt(String.valueOf(currentChar));
                startedParsingNumber = true;
                long checkLongValue = sign * (res * 10L + num);
                if(checkLongValue>Integer.MAX_VALUE || checkLongValue<Integer.MIN_VALUE){
                    checkLongValue = Math.min(Integer.MAX_VALUE, checkLongValue);
                    checkLongValue = Math.max(Integer.MIN_VALUE, checkLongValue);
                    return (int) checkLongValue;
                }
                res = res*10 + num;
            }catch (Exception e){
                if(startedParsingNumber) {
                    return res * sign;
                }else{
                    return 0;
                }
            }
        }
        return res * sign;
    }

    public static void main(String[] args) {
        Prob8_medium prob = new Prob8_medium();
        System.out.println(prob.myAtoi("-124.34")); //-124
        System.out.println(prob.myAtoi("         -124.34")); //-124
        System.out.println(prob.myAtoi("         -124      .3 4")); //-124
        System.out.println(prob.myAtoi("099999999999999999999999999999999999999")); // Integer.MAX_VALUE
        System.out.println(prob.myAtoi("-099999999999999999999999999999999999999")); // Integer.MIN_VALUE
    }
}
