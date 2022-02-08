package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:02 2021/4/23
 */
public class Num160 {

     class ListNode {
          int val;
          ListNode next;
          ListNode(int x) {
              val = x;
              next = null;
          }
    }
    // A+B = B+A
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;

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


    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA;
            ListNode q = headB;
            while (p != q){
                if(p != null)
                    p = p.next;
                else p = headB;

                if(q != null)
                    q = q.next;
                else q = headA;
            }
            return p;
        }
    }


    public static void main(String[] args) {

    }
}
