package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:33 2021/4/28
 */
public class Num141 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
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
        public boolean hasCycle(ListNode head) {
            ListNode p = head;
            ListNode q = head;

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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        System.out.println(hasCycle(n1));
        Solution solution = new Solution();
        System.out.println(solution.hasCycle(n1));
    }
}

