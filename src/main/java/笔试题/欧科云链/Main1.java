package 笔试题.欧科云链;

public class Main1 {


    public class ListNode {
       int val;
        ListNode next = null;
        public ListNode(int val) {
          this.val = val;
        }
      }


    // {1,2,3,4,5},5
    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 1; i <= n; i++) {
            p = p.next;
        }
        if(p == null){
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            dummy.next = dummy.next.next;
            return dummy.next;
        }

        while (p.next != null){
            p = p.next;
            q = q.next;
        }

        if(q.next.next == null){
            q.next = null;
        }
        else
            q.next = q.next.next;

        return head;
    }

    public static void main(String[] args) {

    }
}
