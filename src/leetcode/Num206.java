package leetcode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:16 2021/4/13
 */
public class Num206 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
      /* 解法1，双指针 */
//    public static ListNode reverseList(ListNode head) {
//        ListNode p = null;
//        ListNode q = new ListNode();
//        q = head;
//        while (q != null){
//            ListNode temp = q.next;
//            q.next = p;
//            p = q;
//            q = temp;
//        }
//        return p;
//    }

      /* 解法2，双指针 */
//    public static ListNode reverseList(ListNode head){
//        ListNode h = head;
//        ListNode c = head;
//        if(head == null)
//            return null;
//        while (h.next != null){
//            ListNode temp = h.next.next;
//            h.next.next = c;
//            c = h.next;
//            h.next = temp;
//        }
//        return c;
//    }

    /* 解法3，用递归 */
    public static ListNode reverseList(ListNode head){
        //head == null是为了特别判定原链表的head就是空的情况
        if(head == null || head.next == null){
            return head;
        }
        //r是链表翻转后的头结点
        ListNode r = reverseList(head.next);
        head.next.next = head;
        head.next =null;
        return r;
    }

    /**
     * 第二次练习时的解法
     * @param args
     */
    /*static class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode dummy = new ListNode();
            ListNode p = head;
            ListNode temp;

            while (p != null) {
                temp = p.next;
                p.next = dummy.next;
                dummy.next = p;
                p = temp;
            }

            return dummy.next;
        }
    }*/


    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        /*Solution solution = new Solution();
        node1 = solution.reverseList(node1);*/

        node1 = reverseList(node1);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
    }
}