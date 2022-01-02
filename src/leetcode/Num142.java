package leetcode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/17 21:24
 */

public class Num142 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /*public ListNode detectCycle(ListNode head) {
        //slow每次走一步
        ListNode slow = head;
        //fast每次走两步
        ListNode fast = head;

        while (true){
            //链表无环，fast或者fast.next才会是null
            if(fast == null || fast.next == null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }

        //现在slow和fast相遇了
        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }*/


    //2021.09.17日写
    public static class Solution {
        public ListNode detectCycle(ListNode head) {
            // fast每次走两步
            ListNode fast = head;
            // slow每次走一步
            ListNode slow = head;

            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                //当fast和slow第一次相遇后
                if(fast == slow){
                    //把fast指向head，fast和slow再次相遇时，一定是入环节点
                    fast = head;
                    while (fast != slow){
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return slow;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;

        Solution solution = new Solution();
        System.out.println(solution.detectCycle(n1).val);
    }
}
