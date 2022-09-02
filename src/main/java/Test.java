import LeetCode.ListNode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:36 2022/8/28
 */
public class Test {

    public static ListNode sort(ListNode head){
        if(head==null || head.next==null)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode temp = slow.next;
        slow.next = null;
        sort(head);
        sort(temp);
        return merge(head, temp);
    }

    public static ListNode merge(ListNode head1, ListNode head2){
        if(head1 == null)return head2;
        if(head2 == null)return head1;
        ListNode res , p;
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
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(432);
        ListNode n5 = new ListNode(65);
        ListNode n6 = new ListNode(8);
        ListNode n7 = new ListNode(43290);

        n1.next=n2;n2.next=n3;n3.next=n4;
        n4.next=n5;n5.next=n6;n6.next=n7;

        ListNode ans = sort(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
