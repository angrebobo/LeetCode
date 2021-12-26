/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:53 2021/5/17
 */
public class Num22 {
     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
         if(head == null || k <= 0) return null;
         ListNode p = head;
         for (int i = 1; i < k; i++){
             // p==null说明k大于链表长
             if(p == null)
                 return null;
             p = p.next;
         }


         ListNode q = head;
         while (p.next != null){
             p = p.next;
             q = q.next;
         }
         return q;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        int k = 2;

        System.out.println(getKthFromEnd(node1, k).val);
    }
}
