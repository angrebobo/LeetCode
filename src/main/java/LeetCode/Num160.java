package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:02 2021/4/23
 */
public class Num160 {
    // A+B = B+A
    public ListNode1 getIntersectionNode(ListNode1 headA, ListNode1 headB) {
        ListNode1 p = headA;
        ListNode1 q = headB;
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
         ListNode1 n1 = new ListNode1(1);
         ListNode1 n2 = new ListNode1(2);
         ListNode1 n3 = new ListNode1(3);
         ListNode1 n4 = new ListNode1(4);
         ListNode1 n5 = new ListNode1(5);
         n1.next = n2;
         n3.next = n4;n4.next = n5;
         Num160 num160 = new Num160();
         System.out.println( num160.getIntersectionNode(n1, n3).val );
    }
}
