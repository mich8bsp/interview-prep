package ctci.lists;

import leetcode.helper.ListNode;

public class Q2_3_DeleteMiddleNode {

    //we have access only to the node in the middle of the list
    //we change values to make it look like it's deleted
    public static void deleteMiddleNode(ListNode middleNode){
        while(middleNode.next.next!=null){
            middleNode.val = middleNode.next.val;
            middleNode = middleNode.next;
        }
        middleNode.val = middleNode.next.val;
        middleNode.next = null;
    }
}
