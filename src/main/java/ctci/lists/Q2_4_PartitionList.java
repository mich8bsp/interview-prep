package ctci.lists;

import leetcode.helper.ListNode;

public class Q2_4_PartitionList {

    public static void partitionList(ListNode list, int partitionVal){
        ListNode tail = getTail(list);
        ListNode stopNode = tail;
        //partition first node
        while(list.val>=partitionVal && list!=stopNode){
            tail.next = list;
            tail = tail.next;
            tail.next = null;
            list = list.next;
        }
        while(list.next!=null && list!=stopNode && list.next!=stopNode){
            if(list.next.val>=partitionVal){
                tail.next = list.next;
                tail = tail.next;
                list.next = list.next.next;
                tail.next = null;
            }else{
                list = list.next;
            }
        }
    }

    private static ListNode getTail(ListNode list) {
        while(list.next!=null){
            list = list.next;
        }
        return list;
    }
}
