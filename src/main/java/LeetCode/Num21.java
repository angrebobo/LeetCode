package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/20 21:29
 */

public class Num21 {

    public static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2) {
        ListNode1 p = l1;
        ListNode1 q = l2;
        ListNode1 dummy_head = new ListNode1(0);
        ListNode1 tail = dummy_head;
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
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(4);

        ListNode1 n5 = new ListNode1(1);
        ListNode1 n6 = new ListNode1(3);
        ListNode1 n7 = new ListNode1(4);

        n1.next = n2;
        n2.next = n3;

        n5.next = n6;
        n6.next = n7;

        System.out.println(mergeTwoLists(n1, n5));
    }
}
