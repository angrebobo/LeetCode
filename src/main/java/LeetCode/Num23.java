package LeetCode;

/**
 * @desiption: 合并k个有序链表
 * @author: HuangSiBo
 * @data: 2021/6/8 10:28
 */

public class Num23 {

    public static ListNode1 mergeKLists(ListNode1[] lists) {
           if(lists.length == 0) return null;
           return merge(lists, 0, lists.length-1);
    }

    //关于归并的过程，自己要用调试后一个个看下去真正的执行流程
    public static ListNode1 merge(ListNode1[] lists, int left, int right){
           if(left == right) return lists[left]; //对数组进行“分”，分到最后只有1个元素时，返回
           int mid = left + (right-left)/2;
           ListNode1 l1 = merge(lists, left, mid); //归并左边的有序链表
           ListNode1 l2 = merge(lists, mid+1, right); //归右边的有序链表
           return mergeTwoLists(l1, l2); //合并两边的链表。对数组“分”，一组只有两个链表时，合并这两个链表
    }

    //递归合并两个有序链表
    private static ListNode1 mergeTwoLists(ListNode1 l1, ListNode1 l2){
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
        ListNode1 n1 = new ListNode1(1);
        ListNode1 n2 = new ListNode1(4);
        ListNode1 n3 = new ListNode1(5);
        n1.next = n2;n2.next = n3;

        ListNode1 n11 = new ListNode1(2);
        ListNode1 n22 = new ListNode1(6);
        ListNode1 n33 = new ListNode1(7);
        n11.next = n22;n22.next = n33;

        ListNode1 n111 = new ListNode1(6);
        ListNode1 n222 = new ListNode1(9);
        ListNode1 n333 = new ListNode1(10);
        n111.next = n222;n222.next = n333;

        ListNode1 n1112 = new ListNode1(3);
        ListNode1 n2222 = new ListNode1(6);
        ListNode1 n3332 = new ListNode1(8);
        n1112.next = n2222;n2222.next = n3332;

        ListNode1[] list = new ListNode1[]{n1, n11,n111,n1112};
        mergeKLists(list);
    }
}
