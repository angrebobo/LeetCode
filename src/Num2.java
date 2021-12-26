import java.util.concurrent.CountDownLatch;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/24 12:11
 */

public class Num2 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        int sum;
        ListNode tail = new ListNode();

        while (p!=null && q!=null){
            sum = p.val + q.val + carry;
            if(sum > 9){
                p.val = sum % 10;
                carry  = 1;
            }
            else{
                p.val = sum;
                carry = 0;
            }

            if(p.next == null) tail = p;
            p = p.next;
            q = q.next;
        }
        while (p != null){
            sum = p.val + carry;
            if(sum > 9){
                p.val = sum % 10;
                carry  = 1;
            }
            else{
                p.val = sum;
                carry = 0;
            }
            if(p.next == null) tail = p;
            p = p.next;
        }
        while (q != null){
            sum = q.val + carry;
            if(sum > 9){
                ListNode n = new ListNode(sum % 10);
                tail.next = n;
                tail = tail.next;
                carry  = 1;
            }
            else{
                ListNode n = new ListNode(sum);
                tail.next = n;
                tail = tail.next;
                carry = 0;
            }

            q = q.next;
        }

        if(p == null && q == null && carry == 1){
            ListNode node = new ListNode(1);
            tail.next = node;
        }


        return l1;


    }

    public static void main(String[] args) {
    }
}
