package LeetCode;

import java.util.ArrayList;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/9 14:50
 */

public class Num143 {

     static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void reorderList(ListNode head) {
        ListNode p = head;
        ArrayList<ListNode> list = new ArrayList<>();
        while (p != null){
            list.add(p);
            p = p.next;
        }
        int i = 0, j = list.size()-1;
        ListNode dummy = new ListNode(0);
        p = dummy;
        while (i <= j){
            p.next = list.get(i);
            p = p.next;
            p.next = null;
            if(i != j){
                p.next = list.get(j);
                p = p.next;
                p.next = null;
            }
            i++;
            j--;
        }
        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2; n2.next = n3; /*n3.next = n4;*/
        reorderList(n1);
    }


}
