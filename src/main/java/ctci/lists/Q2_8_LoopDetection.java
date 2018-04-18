package ctci.lists;

import leetcode.helper.ListNode;

public class Q2_8_LoopDetection {

    public static ListNode findLoopStart(ListNode list){

        ListNode turtle = list;
        ListNode hare = list;

        boolean isStart = true;
        // hare moves twice as fast as a turtle. move them both until they meet (maybe after making a few loops)
        while(isStart || turtle != hare){
            isStart = false;
            turtle = turtle.next;
            hare = hare.next.next;
        }

        //denote loop size: m
        // denote distance from start to loop start: k
        // denote distance from loop start to current position: n

        // so we know that hare made (k + i*m + n) steps for some i
        // turtle did (k + j * m + n) steps for some j
        //since hare moved twice as fast we get

        // k+i*m + n = 2k +2j*m + 2n
        // n = (i-2*j)*m - k

        //now if we move the turtle to the start and make hare move at the same speed as the turtle, we need to make k more steps

        //if turtle makes k steps it will be at loop start (that's how we defined k)

        //for hare, if we start counting from loop start we can say that it made n steps so far (that's how we defined n)
        // so if we make k more steps we will get n+k steps from loop start
        // n+k = (i-2j)*m - k + k = (i-2j)*m
        // it's divisible by loop length so we are back at loop start
        //so we need to check if hare and turtle meet and that will be the loop start

        turtle = list;
        while(hare!=turtle){
            hare = hare.next;
            turtle = turtle.next;
        }
        return hare;
    }
}
