package leetcode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/20 10:37
 */

public class Num25 {

    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val;}
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1)
            return head;

        //整个链表分为已翻转部分+待翻转部分+未翻转部分

        //dummy是虚拟的头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        //end是待翻转部分的结尾节点，pre是待翻转部分的第一个节点的前驱节点
        ListNode end = head;
        ListNode pre = dummy;

        while (true){
            //定位到end节点
            for (int i = 1; i < k && end != null; i++) {
                end = end.next;
            }
            //end==null说明待翻转的节点不够k个，直接break返回
            if(end == null)
                break;

            //start是待翻转部分的第一个节点
            ListNode start = pre.next;
            //newPre是下一次待翻转的前驱节点
            ListNode newPre = start;
            //next是待翻转部分的后继节点
            ListNode next = end.next;
            end.next = null;
            reverse(start);

            pre = newPre;
            pre.next = next;
            end = pre.next;
        }

        return dummy.next;
    }

    //翻转链表法1，头插法
    /*private static void reverse(ListNode pre, ListNode end){
        ListNode start = pre.next;
        //p是当前要插入到头节点后的节点
        ListNode p = start.next;
        //next是待翻转部分的后继节点
        ListNode next = end.next;
        ListNode temp;

        while (p != next){
            temp = p.next;
            pre.next = p;
            p.next = start;
            p = temp;

            start = pre.next;
        }
    }*/

    private static void reverse(ListNode start){
        ListNode current = start;
        ListNode pre = null;
        pre.next = start;

        while (current != null){
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
    }


    //翻转链表法3，就地翻转
    /*private static void reverse(ListNode pre, ListNode end){
        ListNode start = pre.next;
        ListNode prev = end.next;
        ListNode p = start;
        ListNode temp;
        while (prev != end){
            temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }
    }*/


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;

        ListNode ans = reverseKGroup(l1, 2);
        System.out.println(ans);
    }
}
