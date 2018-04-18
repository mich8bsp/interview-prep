package leetcode.helper;

public class ListNode {

    /**
     * Definition for singly-linked list.
     **/
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

    @Override
    public String toString() {
        if(next==null){
            return "" + val + "->null";
        }
        return "" + val + "->" + next.toString();
    }
}
