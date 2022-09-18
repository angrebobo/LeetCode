package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:48 2022/9/3
 */
public class Num147 {

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            if(head==null || head.next==null)
                return head;

            ListNode dummy = new ListNode();
            dummy.next = head;
            // lastSorted:已排序部分的末节点
            ListNode lastSorted = head;
            // p:待排序部分的首节点
            ListNode p = lastSorted.next;

            while (p != null){
                if(p.val > lastSorted.val){
                    lastSorted = p;
                }
                else {
                    ListNode temp = dummy;
                    lastSorted.next = p.next;
                    // 找到p在已排序部分的位置
                    while (temp.next.val < p.val)
                        temp = temp.next;
                    p.next = temp.next;
                    temp.next = p;
                }
                p = lastSorted.next;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Solution solution = new Solution();
        ListNode ans = solution.insertionSortList(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
