package leetcode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”.
 For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class Prob412_easy {

    public List<String> fizzBuzz(int n) {
        if(n<=0){
            return Collections.emptyList();
        }
        return IntStream.range(1, n+1)
                .boxed()
                .map(i -> {
                    StringBuilder res = new StringBuilder();
                    if(i%3 == 0){
                        res.append("Fizz");
                    }
                    if(i%5 == 0){
                        res.append("Buzz");
                    }
                    if(res.length()==0){
                        res.append(i);
                    }
                    return res.toString();
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Prob412_easy prob = new Prob412_easy();

        prob.fizzBuzz(15).forEach(System.out::println);
//        1
//        2
//        Fizz
//        4
//        Buzz
//        Fizz
//        7
//        8
//        Fizz
//        Buzz
//        11
//        Fizz
//        13
//        14
//        FizzBuzz

    }
}
