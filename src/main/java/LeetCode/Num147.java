package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:48 2022/9/3
 */
public class Num147 {

    static class Solution {
        public ListNode1 insertionSortList(ListNode1 head) {
            if(head==null || head.next==null)
                return head;

            ListNode1 dummy = new ListNode1();
            dummy.next = head;
            // lastSorted:已排序部分的末节点
            ListNode1 lastSorted = head;
            // p:待排序部分的首节点
            ListNode1 p = lastSorted.next;

            while (p != null){
                if(p.val > lastSorted.val){
                    lastSorted = p;
                }
                else {
                    ListNode1 temp = dummy;
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
        ListNode1 n1 = new ListNode1(4);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(1);
        ListNode1 n4 = new ListNode1(3);
        ListNode1 n5 = new ListNode1(5);
        ListNode1 n6 = new ListNode1(0);
        ListNode1 n7 = new ListNode1(7);
        ListNode1 n8 = new ListNode1(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        Solution solution = new Solution();
        ListNode1 ans = solution.insertionSortList(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
