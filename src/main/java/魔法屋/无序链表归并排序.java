package 魔法屋;

import LeetCode.ListNode1;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:36 2022/8/28
 */
public class 无序链表归并排序 {

    public static ListNode1 sort(ListNode1 head){
        if(head==null || head.next==null)
            return head;

        // 快慢指针找到链表中间节点
        ListNode1 fast = head;
        ListNode1 slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode1 temp = slow.next;
        // !!!这一步很关键，将第一个链表的尾节点断开
        slow.next = null;
        sort(head);
        sort(temp);
        return merge(head, temp);
    }

    public static ListNode1 merge(ListNode1 head1, ListNode1 head2){
        if(head1 == null)return head2;
        if(head2 == null)return head1;
        ListNode1 res , p;
        if(head1.val < head2.val) {
            res = head1;
            head1 = head1.next;
        }
        else{
            res = head2;
            head2 = head2.next;
        }

        p = res;

        while(head1 != null && head2 != null)
        {
            if(head1.val < head2.val) {
                p.next = head1;
                head1 = head1.next;
            }
            else {
                p.next = head2;
                head2 = head2.next;
            }
            p = p.next;
        }
        if(head1 != null)
            p.next = head1;
        if(head2 != null)
            p.next = head2;
        return res;
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(5);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(432);
        ListNode1 n5 = new ListNode1(65);
        ListNode1 n6 = new ListNode1(8);
        ListNode1 n7 = new ListNode1(43290);

        n1.next=n2;n2.next=n3;n3.next=n4;
        n4.next=n5;n5.next=n6;n6.next=n7;

        ListNode1 ans = sort(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
