package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:51 2022/6/28
 */
public class Num24 {

    static class Solution {
        //迭代
        public ListNode1 swapPairs(ListNode1 head){
            ListNode1 pre = new ListNode1();
            pre.next = head;
            ListNode1 temp = pre;
            while (temp.next!=null && temp.next.next!=null){
                ListNode1 start = temp.next;
                ListNode1 end = temp.next.next;
                start.next = end.next;
                end.next = start;
                temp.next = end;
                temp = start;
            }

            return pre.next;
        }
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(4);
        n1.next = n2;n2.next = n3;n3.next = n4;
        Solution solution = new Solution();
        System.out.println(solution.swapPairs(n1).val);
    }
}
