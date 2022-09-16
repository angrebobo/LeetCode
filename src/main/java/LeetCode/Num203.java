package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:42 2022/6/14
 */
public class Num203 {

    static class Solution {
        public ListNode1 removeElements(ListNode1 head, int val) {
            ListNode1 dummy = new ListNode1();
            dummy.next = head;
            ListNode1 pre = dummy;
            ListNode1 p = head;
            while (p != null){
                if(p.val == val){
                    pre.next = p.next;
                    p = p.next;
                }
                else {
                    pre = p;
                    p = p.next;
                }
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(6);
        ListNode1 n4 = new ListNode1(3);
        ListNode1 n5 = new ListNode1(4);
        ListNode1 n6 = new ListNode1(5);
        ListNode1 n7 = new ListNode1(6);
        n1.next = n2;n2.next =n3;n3.next=n4;n4.next = n5;n5.next=n6;n6.next=n7;

        Solution solution = new Solution();
        System.out.println(solution.removeElements(n1, 6));
    }
}
