package leetcode;

import leetcode.helper.ListNode;

/*

You are given two non-empty linked lists representing two non-negative integers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.
*/
public class Prob2_easy {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        addTwoNumbers(l1, l2, result, 0);
        return result;
    }

    private void addTwoNumbers(ListNode l1, ListNode l2, ListNode result, int carry) {
        int currentFromL1 = l1 != null ? l1.val : 0;
        int currentFromL2 = l2 != null ? l2.val : 0;
        int currentSum = currentFromL1 + currentFromL2 + carry;
        result.val = currentSum % 10;
        int newCarry = currentSum / 10;

        ListNode newL1 = l1 != null ? l1.next : null;
        ListNode newL2 = l2 != null ? l2.next : null;
        if (newL1 != null || newL2 != null || newCarry > 0) {
            result.next = new ListNode(0);
            addTwoNumbers(newL1, newL2, result.next, newCarry);
        }
    }

    public static void main(String[] args) {
        Prob2_easy prob = new Prob2_easy();
        ListNode n1 = new ListNode(2);
        n1.next = new ListNode(4);
        n1.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        ListNode res = prob.addTwoNumbers(n1, n2);
        while (res != null) {
            System.out.print(res.val);
            res = res.next;
        }
        // 708
    }
}
