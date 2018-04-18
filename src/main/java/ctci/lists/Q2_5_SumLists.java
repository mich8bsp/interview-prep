package ctci.lists;

import leetcode.helper.ListNode;

import java.util.Optional;

public class Q2_5_SumLists {

    public static ListNode sumLists(ListNode firstNum, ListNode secondNum) {
        ListNode root = new ListNode(0);

        ListNode currSumDigit = root;
        ListNode currNum1Digit = firstNum;
        ListNode currNum2Digit = secondNum;

        int carry = 0;
        while (currSumDigit!=null) {
            int num1Digit = Optional.ofNullable(currNum1Digit).map(x -> x.val).orElse(0);
            int num2Digit = Optional.ofNullable(currNum2Digit).map(x -> x.val).orElse(0);
            int sum = carry + num1Digit + num2Digit;
            currSumDigit.val = sum % 10;
            carry = sum / 10;
            if (currNum1Digit != null) {
                currNum1Digit = currNum1Digit.next;
            }
            if (currNum2Digit != null) {
                currNum2Digit = currNum2Digit.next;
            }
            if (currNum1Digit == null && currNum2Digit == null) {
                currSumDigit.next = null;
            } else {
                currSumDigit.next = new ListNode(0);
            }
            currSumDigit = currSumDigit.next;
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode firstNumber = new ListNode(7);
        firstNumber.next = new ListNode(1);
        firstNumber.next.next = new ListNode(6);

        ListNode secondNumber = new ListNode(5);
        secondNumber.next = new ListNode(9);
        secondNumber.next.next = new ListNode(2);

        System.out.println(sumLists(firstNumber, secondNumber)); // 2->1->9->null  ( 617 + 295) = 912
        secondNumber.next.next = null;
        System.out.println(sumLists(firstNumber, secondNumber)); // 2->1->7->null (617 + 95) = 712
    }
}
