package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:42 2022/6/14
 */
public class Num203 {
     static public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    static class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode pre = dummy;
            ListNode p = head;
            while (p != null){
                if(p.val == val){
                    pre.next = p.next;
                    p = p.next;
                }
                else {
                    pre = p;
                    p = p.next;
                }
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(6);
        n1.next = n2;n2.next =n3;n3.next=n4;n4.next = n5;n5.next=n6;n6.next=n7;

        Solution solution = new Solution();
        System.out.println(solution.removeElements(n1, 6));
    }
}
