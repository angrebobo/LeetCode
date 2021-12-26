/*
import java.util.List;

*/


import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:15 2021/5/12
 */

public class Num92 {
    static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //我自己写的解法，繁冗复杂
    /*public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right)
            return head;

        ListNode p = head;
        //pre_start是left的前一个节点
        ListNode pre_start = new ListNode();
        ListNode start = new ListNode();
        ListNode end = new ListNode();
        int len = 1;
        while (p != null){
            if(left-1 == len)
                pre_start = p;
            if(left == len)
                start = p;
            if(right == len)
                end = p;

            p = p.next;
            len++;
        }
        if(left == 1) pre_start.next = head;
        //因为while循环里len多加了一次，所以减1后才是链表的长度
        len--;

        p = start.next;
        ListNode after_end = end.next;
        start.next = after_end;
        ListNode temp;
        //头插法
        while (p != after_end){
            temp = p.next;
            p.next = pre_start.next;
            pre_start.next = p;
            p = temp;
        }
        //left==1是特殊情况
        if(left == 1) return pre_start.next;
        else
            return head;
    }*/

    //改进后的解法，题解链接是https://leetcode-cn.com/problems/reverse-linked-list-ii/
    // solution/java-shuang-zhi-zhen-tou-cha-fa-by-mu-yi-cheng-zho/
    public static ListNode reverseBetween(ListNode head, int left, int right){
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode current = dummy.next;

        //pre指向left节点的前节点，current指向left节点
        for (int i = 0; i < left-1; i++) {
            pre = pre.next;
            current = current.next;
        }

        //头插法，temp是当前要插入头部的节点
        //这个头插法比我自己写的要好
        for (int i = left; i < right ; i++) {
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        System.out.println(reverseBetween(node1, 1, 2));

    }
}

