package LeetCode;

import java.util.ArrayList;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/9 14:50
 */

public class Num143 {

    /*public static void reorderList(ListNode head) {
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
    }*/

    public static void reorderList(ListNode1 head) {
        ArrayList<ListNode1> list = new ArrayList<>();
        ListNode1 p = head;
        while (p != null){
            list.add(p);
            p = p.next;
        }

        int len = list.size();
        for (int i = 0; i < len/2; i++) {
            list.get(i).next = list.get(len-1-i);
            if(i+1<len-1-i)
                list.get(len-1-i).next = list.get(i+1);
        }

        list.get(len/2).next = null;
    }

    public static void main(String[] args) {
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(3);
        ListNode1 n4 = new ListNode1(4);
//        ListNode n5 = new ListNode(5);
        n1.next = n2; n2.next = n3; n3.next = n4;/*n4.next = n5;*/
        reorderList(n1);
        ListNode1 p = n1;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }


}
