package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:30 2022/4/5
 */
public class Num86 {

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
        public ListNode1 partition(ListNode1 head, int x){
            //将小于x的元素抽出来单独组成一个链表
            ListNode1 smallHead = new ListNode1(0);
            ListNode1 smallTail = smallHead;
            ListNode1 largeHead = new ListNode1(0);
            ListNode1 largeTail = largeHead;

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
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(4);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(2);
        ListNode1 n5 = new ListNode1(5);
        ListNode1 n6 = new ListNode1(0);
        n1.next = n2;n2.next = n3;
        n3.next = n4;n4.next = n5;
        n5.next = n6;
//        ListNode n1 = new ListNode(2);
//        ListNode n2 = new ListNode(1);
//        n1.next = n2;

        Solution solution = new Solution();
        ListNode1 res = solution.partition(n1, 3);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }
}
