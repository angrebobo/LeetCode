package 左神算法;

import LeetCode.ListNode1;

/**
 * @author: HuangSiBo
 * @Description: 给定两个可能有环也可能无环的单链表，头结点head1和head2。请实现一个函数，如果
 * 两个链表相交，请返回相交的第一个节点。如果不相交，返回null。
 * 如果两个链表长度之和为N，时间复杂度请达到O(N),额外空间复杂度达到O(1)
 * @Data: Created in 0:10 2022/4/10
 */
public class IntersectionList {

    /**
     * @Description 返回链表环的第一个入口节点，若链表无环则返回null
     *
     */
    public ListNode1 detectCycle(ListNode1 head){
        ListNode1 slow = head;
        ListNode1 quick = head;
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

    /**
     * 两个无环单链表求相交节点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode1 noLoop(ListNode1 head1, ListNode1 head2){
        ListNode1 p = head1;
        ListNode1 q = head2;

        while (p != q){
            if(p != null)
                p = p.next;
            else
                p = head2;

            if(q != null)
                q = q.next;
            else
                q = head1;
        }
        return p;
    }

    /**
     * 两个有环单链表求相交节点
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public ListNode1 bothLoop(ListNode1 head1, ListNode1 loop1, ListNode1 head2, ListNode1 loop2){
        //链表相交，交点在环外
        if(loop1 == loop2){
            ListNode1 loop1Next = loop1.next;
            ListNode1 loop2Next = loop2.next;
            loop1.next = null;
            loop2.next = null;

            ListNode1 intersection = noLoop(head1, head2);

            //还原链表结构
            loop1.next = loop1Next;
            loop2.next = loop2Next;

            return intersection;
        }
        //两种情况：1、链表相交，交点在环内 2、两个有环链表不相交
        else {
            int count = 0;
            boolean flag = false;
            ListNode1 p = head1;

            while (count <= 2){
                if(p == loop1)
                    count++;
                if(p == loop2){
                    flag = true;
                    break;
                }
                p = p.next;
            }

            return !flag ? null : loop1;
        }
    }

    /**
     * 返回链表相交的第一个节点
     * @param head1
     * @param head2
     * @return
     */
    public ListNode1 getIntersectionNode(ListNode1 head1, ListNode1 head2){
        //获取两个链表的入环节点
        ListNode1 loop1 = detectCycle(head1);
        ListNode1 loop2 = detectCycle(head2);

        //两个链表都无环
        if(loop1==null && loop2==null){
            return noLoop(head1, head2);
        }
        //两个链表都有环
        else if(loop1!=null && loop2!=null){
            return bothLoop(head1, loop1, head2, loop2);
        }
        //一个链表有环，一个链表无环，不可能相交
        else {
            return null;
        }
    }


    public static void main(String[] args) {
        IntersectionList intersectionList = new IntersectionList();
        ListNode1 res;

        //两个无环单链表，相交
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n5;
        ListNode n6 = new ListNode(6);
        n6.next = n3;
        //n1,n6都是无环单链表,相交与n3节点
        if( intersectionList.getIntersectionNode(n1, n6)!=null )
            System.out.println( intersectionList.getIntersectionNode(n1, n6).val );
        else
            System.out.println("null");*/

        //两个无环单链表，不相交
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(6);
        n6.next = n7;
        //n1,n6都是无环单链表,不相交
        if( intersectionList.getIntersectionNode(n1, n6)!=null )
            System.out.println( intersectionList.getIntersectionNode(n1, n6).val );
        else
            System.out.println("null");*/

        //一个有环单链表，一个无环单链表
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n2;
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n5.next = n6;
        //n1有环，n5无环
        if( intersectionList.getIntersectionNode(n1, n5)!=null )
            System.out.println( intersectionList.getIntersectionNode(n1, n6).val );
        else
            System.out.println("null");*/

        //两个有环单链表，不相交
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n2;
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n5.next = n6;n6.next = n5;
        //n1有环，n5有环，不相交
        if( (res=intersectionList.getIntersectionNode(n1, n5)) != null )
            System.out.println( res.val );
        else
            System.out.println("null");*/

        //两个有环单链表，相交，交点在环外
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n3;
        ListNode n5 = new ListNode(5);
        n5.next = n2;
        //n1有环，n5有环，交点在环外为n2
        if( (res=intersectionList.getIntersectionNode(n1, n5)) != null )
            System.out.println( res.val );
        else
            System.out.println("null");*/

        //两个有环单链表，相交，交点在环内
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(4);
        n1.next = n2;n2.next = n3;n3.next = n4;n4.next = n3;
        ListNode1 n5 = new ListNode1(5);
        n5.next = n4;
        //n1有环，n5有环，交点在环内为n4
        if( (res=intersectionList.getIntersectionNode(n1, n5)) != null )
            System.out.println( res.val );
        else
            System.out.println("null");

    }
}
