package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/2 16:11
 */

public class Offer_Num22 {

    public ListNode1 getKthFromEnd(ListNode1 head, int k) {
        ListNode1 p = head;
        ListNode1 q = head;
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
