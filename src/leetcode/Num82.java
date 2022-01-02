package leetcode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/7/17 20:33
 */

public class Num82 {

    static class ListNode {
        int val;
        ListNode next;
        public ListNode() {}
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode next){ val=x;this.next=next;}
    }


    /*public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode move;
        if(head.val != head.next.val){
            head.next = deleteDuplicates(head.next);
            return head;
        }
        else {
            move = head;
            while (move.next!=null && move.val == move.next.val){
                move = move.next;
            }
            return deleteDuplicates(move.next);
        }
    }*/


    /**
     * @Description 2021.10.05写
     * @param
     * @return
     */
    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode p = head;
            ListNode pre = dummy;
            while (p != null){
                while (p.next != null && p.val == p.next.val){
                    p = p.next;
                }
                if(pre.next == p)
                    pre = pre.next;
                else
                    pre.next = p.next;

                p = p.next;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;
        // ListNode dummy = deleteDuplicates(n1);

        Solution solution = new Solution();
        solution.deleteDuplicates(n1);

    }
}
