package leetcode;

import leetcode.helper.ListNode;

public class Prob328_medium {

        public leetcode.helper.ListNode oddEvenList(leetcode.helper.ListNode head) {
            if(head.next==null || head.next.next == null){
                return head;
            }

            ListNode pointer = head;

            ListNode last = getLast(head);

            ListNode stopNode = last;
            while(pointer != null && pointer.next!=null && pointer!=stopNode){
                last.next = pointer.next;
                pointer.next = pointer.next.next;
                last = last.next;
                last.next = null;

                pointer = pointer.next;
            }

            return head;
        }

    private leetcode.helper.ListNode getLast(ListNode root) {
        while(root.next!=null){
            root = root.next;
        }
        return root;
    }

    public static void main(String[] args) {
        Prob328_medium prob = new Prob328_medium();
        leetcode.helper.ListNode head = new ListNode(1);
        ListNode nextNode = head;
        nextNode.next = new ListNode(2);
        nextNode = nextNode.next;
        nextNode.next = new ListNode(3);
        nextNode = nextNode.next;
        nextNode.next = new ListNode(4);
        nextNode = nextNode.next;
        nextNode.next = new ListNode(5);

        nextNode = prob.oddEvenList(head);
        while(nextNode!=null) {
            System.out.println(nextNode.val);
            nextNode = nextNode.next;
        }
    }
}
