package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/7/17 20:33
 */

public class Num82 {

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
        public ListNode1 deleteDuplicates(ListNode1 head) {
            ListNode1 dummy = new ListNode1();
            dummy.next = head;
            ListNode1 p = head;
            ListNode1 pre = dummy;
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
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(3);
        ListNode1 n5 = new ListNode1(4);
        ListNode1 n6 = new ListNode1(4);
        ListNode1 n7 = new ListNode1(5);
        n1.next=n2;n2.next=n3;n3.next=n4;n4.next=n5;n5.next=n6;n6.next=n7;
        // ListNode dummy = deleteDuplicates(n1);

        Solution solution = new Solution();
        solution.deleteDuplicates(n1);

    }
}
