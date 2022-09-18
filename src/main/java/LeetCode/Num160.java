package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:02 2021/4/23
 */
public class Num160 {
    // A+B = B+A
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) {
            if(p != null)
                p = p.next;
            else
                p = headB;

            if(q != null)
                q = q.next;
            else
                q = headA;
        }
        return p;
    }


    public static void main(String[] args) {
         ListNode n1 = new ListNode(1);
         ListNode n2 = new ListNode(2);
         ListNode n3 = new ListNode(3);
         ListNode n4 = new ListNode(4);
         ListNode n5 = new ListNode(5);
         n1.next = n2;
         n3.next = n4;n4.next = n5;
         Num160 num160 = new Num160();
         System.out.println( num160.getIntersectionNode(n1, n3).val );
    }
}
