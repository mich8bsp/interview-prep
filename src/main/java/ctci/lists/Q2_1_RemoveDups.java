package ctci.lists;

import leetcode.helper.ListNode;

import java.util.HashMap;

public class Q2_1_RemoveDups {

    public static void removeDuplicates(ListNode list){
        //solution 1: hold hashmap and for each element store it in hashmap. If we encounter an element which is already stored,
        //it's a duplicate and should be removed.

        HashMap<Integer, Boolean> encountered = new HashMap<>();
        if(list==null || list.next==null){
            return;
        }
        ListNode currNode = list;
        encountered.put(currNode.val, true);
        ListNode nextNode = list.next;

        while(nextNode!=null){
            if(encountered.containsKey(nextNode.val)){
                currNode.next = nextNode.next;
                nextNode = currNode.next;
                continue;
            }
            encountered.put(nextNode.val, true);
            currNode = nextNode;
            nextNode = currNode.next;
        }
    }
}
