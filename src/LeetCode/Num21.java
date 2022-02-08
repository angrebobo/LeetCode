package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/20 21:29
 */

public class Num21 {

     static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode dummy_head = new ListNode(0);
        ListNode tail = dummy_head;
        while (p!=null && q!=null){
            if(p.val < q.val){
                tail.next = p;
                p = p.next;
            }
            else {
                tail.next = q;
                q = q.next;
            }
            tail = tail.next;
        }

        if (p != null){
            tail.next = p;
        }
        if (q != null){
            tail.next = q;
        }

        return dummy_head.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);

        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;

        n5.next = n6;
        n6.next = n7;

        System.out.println(mergeTwoLists(n1, n5));
    }
}
