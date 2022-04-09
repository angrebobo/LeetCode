/**
 * @author: HuangSiBo
 * @Description: 给定两个可能有环也可能无环的单链表，头结点head1和head2。请实现一个函数，如果
 * 两个链表相交，请返回相交的第一个节点。如果不相交，返回null。
 * 如果两个链表长度之和为N，时间复杂度请达到O(N),额外空间复杂度达到O(1)
 * @Data: Created in 0:10 2022/4/10
 */
public class IntersectionList {

    //定义链表节点
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * @Description 返回链表环的第一个入口节点，若链表无环则返回null
     * @param
     * @return
     */
    public ListNode isIntersection(ListNode head){
        ListNode slow = head;
        ListNode quick = head;
        while (quick!=null && quick.next!=null){
            slow = slow.next;
            quick = quick.next.next;

            if(slow == quick)
                break;
        }
        //链表无环
        if(quick==null || quick.next==null)
            return null;
        //链表有环
        else {
            quick = head;
            while (quick != slow){
                quick = quick.next;
                slow = slow.next;
            }
            return slow;
        }
    }


    public static void main(String[] args) {

    }
}
