package NewLeetCode;

import java.util.HashSet;

/**
 * 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/?envType=study-plan-v2&envId=top-100-liked
 * 题解：https://leetcode.cn/problems/intersection-of-two-linked-lists/solutions/2958778/tu-jie-yi-zhang-tu-miao-dong-xiang-jiao-m6tg1
 */
public class Num160 {

    /**
     * 解法1，集合
     * 时间复杂度O(m+n),m和n是链表的长度
     * 空间复杂度O(m)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null){
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }

        return null;
    }

    /**
     * 双指针，思路很巧妙
     * A链表的长度是a+c，b链表的长度是b+c
     * p指针遍历完A链表，再遍历B链表
     * q指针遍历完B链表，再遍历A链表
     * 两个指针就会在交汇点重合
     * (a+c)+b=(b+c)+a
     * 哪怕A链表和B链表没有交汇，两个指针会同时等会null，相当于在空节点重合
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB){
        ListNode p = headA;
        ListNode q = headB;
        while (p != q){
            // 这里我自己写的代码是 p = (p.next != null) ? p.next : headB,会导致指针永远不等于null，无限循环下去
            p = (p != null) ? p.next : headB;
            q = (q != null) ? q.next : headA;
        }
        return p;
    }

    public static void main(String[] args) {

    }

    private class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
