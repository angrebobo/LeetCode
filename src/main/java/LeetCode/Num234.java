package LeetCode;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:11 2022/4/3
 */
public class Num234 {

    static class Solution {
        public boolean isPalindrome(ListNode1 head) {
            Stack<ListNode1> stack = new Stack<>();
            ListNode1 slow = head;
            ListNode1 qucik = head;
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
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(2);
        ListNode1 n4 = new ListNode1(1);
        n1.next = n2;n2.next = n3;n3.next = n4;

        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(n1));
    }
}
