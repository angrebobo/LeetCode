package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:33 2021/4/28
 */
public class Num141 {
//    public static boolean hasCycle(ListNode head) {
//        if(head == null )
//            return false;
//        //p是慢指针,每次移动一次
//        ListNode p = head;
//        //q是快指针，每次移动两次
//        ListNode q = head;
//        while (q != null && q.next != null){
//            q = q.next.next;
//            p = p.next;
//            if(p == q)
//                return true;
//        }
//        return false;
//    }

     static class Solution {
        public boolean hasCycle(ListNode1 head) {
            ListNode1 p = head;
            ListNode1 q = head;

            while (q!=null && q.next!=null){
                q = q.next.next;
                p = p.next;
                if(q == p)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        System.out.println(hasCycle(n1));
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(n1));
    }
}

