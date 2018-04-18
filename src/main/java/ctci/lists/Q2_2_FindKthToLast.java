package ctci.lists;

import leetcode.helper.ListNode;

public class Q2_2_FindKthToLast {

    public static int findKthToLast(ListNode list, int k){
        int size = findSize(list);
        if(k>=size){
            throw new IllegalArgumentException();
        }
        return findValueAtIndex(list, size-k);
    }

    private static int findValueAtIndex(ListNode list, int idx) {
        if(idx==0){
            return list.val;
        }
        return findValueAtIndex(list.next, idx-1);
    }

    private static int findSize(ListNode list) {
        if(list==null){
            return 0;
        }
        return findSize(list.next) + 1;
    }

}
