package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/24 12:11
 */

public class Num2 {

    public ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
        ListNode1 p = l1;
        ListNode1 q = l2;
        int carry = 0;
        int sum;
        ListNode1 tail = new ListNode1();

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
                ListNode1 n = new ListNode1(sum % 10);
                tail.next = n;
                tail = tail.next;
                carry  = 1;
            }
            else{
                ListNode1 n = new ListNode1(sum);
                tail.next = n;
                tail = tail.next;
                carry = 0;
            }

            q = q.next;
        }

        if(p == null && q == null && carry == 1){
            ListNode1 node = new ListNode1(1);
            tail.next = node;
        }


        return l1;


    }

    public static void main(String[] args) {
    }
}
