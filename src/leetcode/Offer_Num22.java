package leetcode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/2 16:11
 */

public class Offer_Num22 {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < k-1; i++) {
            p = p.next;
        }
        while (true){
            p = p.next;
            if(p == null)
                break;
            q = q.next;
        }
        return q;
    }


    public static void main(String[] args) {

    }
}
