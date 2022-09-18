package LeetCode;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:11 2022/4/3
 */
public class Num234 {

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode slow = head;
            ListNode qucik = head;
            while (qucik.next != null){
                slow = slow.next;
                qucik = qucik.next.next;
            }

            while (head != null){
                slow = stack.pop();
                if(head.val != slow.val)
                    return false;
                head = head.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;n2.next = n3;n3.next = n4;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(n1));
    }
}
