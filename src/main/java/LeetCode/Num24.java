package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:51 2022/6/28
 */
public class Num24 {

    static class Solution {
        //迭代
        public ListNode swapPairs(ListNode head){
            ListNode pre = new ListNode();
            pre.next = head;
            ListNode temp = pre;
            while (temp.next!=null && temp.next.next!=null){
                ListNode start = temp.next;
                ListNode end = temp.next.next;
                start.next = end.next;
                end.next = start;
                temp.next = end;
                temp = start;
            }

            return pre.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = n3;n3.next = n4;
        Solution solution = new Solution();
        System.out.println(solution.swapPairs(n1).val);
    }
}
