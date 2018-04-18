package ctci.lists;

import leetcode.helper.ListNode;

import java.util.Stack;

public class Q2_6_ListIsPalindrome {

    public static boolean isPalindrome(ListNode list){
        ListNode reversed = reverse(list);

        while(list!=null && reversed!=null){
            if(list.val!=reversed.val){
                return false;
            }
            list = list.next;
            reversed = reversed.next;
        }
        return list==null && reversed==null;
    }

    private static ListNode reverse(ListNode list) {
        Stack<ListNode> stack = new Stack<>();
        while(list!=null){
            stack.push(new ListNode(list.val));
            list = list.next;
        }

        ListNode root = stack.pop();
        ListNode currPopped = root;
        while(!stack.isEmpty()){
            currPopped.next = stack.pop();
            currPopped = currPopped.next;
        }
        currPopped.next = null;
        return root;
    }

    public static void main(String[] args) {
        ListNode lst = new ListNode(7);
        lst.next = new ListNode(1);
        lst.next.next = new ListNode(6);
        System.out.println(isPalindrome(lst)); //false

        lst.next.next.val = 7;
        System.out.println(isPalindrome(lst)); // true
    }
}
