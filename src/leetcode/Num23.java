package leetcode;

/**
 * @desiption: 合并k个有序链表
 * @author: HuangSiBo
 * @data: 2021/6/8 10:28
 */

public class Num23 {

       static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode mergeKLists(ListNode[] lists) {
           if(lists.length == 0) return null;
           return merge(lists, 0, lists.length-1);
    }

    //关于归并的过程，自己要用调试后一个个看下去真正的执行流程
    public static ListNode merge(ListNode[] lists, int left, int right){
           if(left == right) return lists[left]; //对数组进行“分”，分到最后只有1个元素时，返回
           int mid = left + (right-left)/2;
           ListNode l1 = merge(lists, left, mid); //归并左边的有序链表
           ListNode l2 = merge(lists, mid+1, right); //归右边的有序链表
           return mergeTwoLists(l1, l2); //合并两边的链表。对数组“分”，一组只有两个链表时，合并这两个链表
    }

    //递归合并两个有序链表
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2){
           if(l1 == null) return l2;
           if(l2 == null) return l1;
           if(l1.val < l2.val){
               l1.next = mergeTwoLists(l1.next, l2);
               return l1;
           }
           else {
               l2.next = mergeTwoLists(l1, l2.next);
               return l2;
           }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;n2.next = n3;

        ListNode n11 = new ListNode(2);
        ListNode n22 = new ListNode(6);
        ListNode n33 = new ListNode(7);
        n11.next = n22;n22.next = n33;

        ListNode n111 = new ListNode(6);
        ListNode n222 = new ListNode(9);
        ListNode n333 = new ListNode(10);
        n111.next = n222;n222.next = n333;

        ListNode n1112 = new ListNode(3);
        ListNode n2222 = new ListNode(6);
        ListNode n3332 = new ListNode(8);
        n1112.next = n2222;n2222.next = n3332;

        ListNode[] list = new ListNode[]{n1, n11,n111,n1112};
        mergeKLists(list);
    }
}
