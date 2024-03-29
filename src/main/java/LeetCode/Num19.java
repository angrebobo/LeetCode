package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:54 2021/8/11
 */
public class Num19 {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        ListNode pre_q = head;

        int n1 = n;
        while (n1-- > 0){
            p = p.next;
        }
        // 防止head = [1], n = 1这种情况
        if(n==1 && p == null){
            return null;
        }
        // n==链表长度
        else if(p == null){
            return head.next;
        }

        n1 = -1;
        while (p != null){
               p = p.next;
               q = q.next;
               n1++;
               if(n1 >= 1)
                   pre_q = pre_q.next;
        }

        pre_q.next = pre_q.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next=n2;
        /*ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n2.next=n3;n3.next=n4;n4.next=n5;*/

        ListNode ans = removeNthFromEnd(n1, 2);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
