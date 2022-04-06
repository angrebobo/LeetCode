package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:30 2022/4/5
 */
public class Num86 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        /*public ListNode partition(ListNode head, int x) {
            //将小于x的元素抽出来单独组成一个链表
            ListNode smallHead = null;
            ListNode smallTail = null;
            ListNode temp = head;
            ListNode pre = new ListNode();
            pre.next = head;

            while (temp != null){
                if(temp.val < x){
                    //把temp从原链表移除
                    pre.next = temp.next;
                    temp.next = null;
                    if(temp == head){
                        head = pre.next;
                    }

                    if(smallHead == null){
                        smallHead = temp;
                        smallTail = temp;
                        smallHead.next = smallTail;
                    }
                    else {
                        smallTail.next = temp;
                        smallTail = temp;
                    }

                    temp = pre.next;
                }
                else {
                    temp = temp.next;
                    pre = pre.next;
                }
            }

            //将smallHead与原链表合并
            if(smallHead == null)
                return head;
            else {
                smallTail.next = head;
                return smallHead;
            }
        }*/

        //方法2
        public ListNode partition(ListNode head, int x){
            //将小于x的元素抽出来单独组成一个链表
            ListNode smallHead = new ListNode(0);
            ListNode smallTail = smallHead;
            ListNode largeHead = new ListNode(0);
            ListNode largeTail = largeHead;

            while (head != null){
                if(head.val < x){
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
                else {
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
                head = head.next;
            }
            //这一步很关键，切断联系
            largeTail.next = null;
            smallTail.next = largeHead.next;
            return smallHead.next;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(0);
        n1.next = n2;n2.next = n3;
        n3.next = n4;n4.next = n5;
        n5.next = n6;
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(1);
//        n1.next = n2;

        Solution solution = new Solution();
        ListNode res = solution.partition(n1, 3);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
