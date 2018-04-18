package ctci.lists;

import leetcode.helper.ListNode;

public class Q2_7_Intersection {

    public static boolean checkIfIntersect(ListNode list1, ListNode list2){
        //if both lists have a common node - it means their tails are the same
        //because the next value of this common node is the same in both lists
        //so it's enough to check if they have the same tail

        ListNode tail1 = findTail(list1);
        ListNode tail2 = findTail(list2);

        return tail1==tail2;
    }

    private static ListNode findTail(ListNode list){
        while(list.next!=null){
            list = list.next;
        }
        return list;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(1);
        ListNode root2 = new ListNode(3);
        root1.next = new ListNode(2);
        root2.next = new ListNode(5);

        root1.next.next = new ListNode(6);
        root2.next.next = root1.next.next;

        root1.next.next.next = new ListNode(35);

        System.out.println(checkIfIntersect(root1, root2)); // true
    }
}
