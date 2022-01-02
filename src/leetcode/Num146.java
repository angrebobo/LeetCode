package leetcode;

import java.util.HashMap;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/17 15:35
 */

public class Num146 {

      static class LRUCache {

         //建一个双向链表，优先级越高的ListNode离头节点越近
         class ListNode{
            ListNode previous;
            ListNode next;
            int val;
            int key;

            public ListNode(int key, int val) {
                 this.val = val;
                 this.key = key;
            }
         }
         //双向链表的头节点
        ListNode head = new ListNode(0, 0);

        HashMap<Integer, ListNode> map = new HashMap<>();
         //map的最大容量
        int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;

            head.next = head;
            head.previous = head;
        }

        public int get(int key) {
            if(map.containsKey(key)){
                //更新node的优先级
                moveToHead(head, map.get(key));

                return map.get(key).val;
            }
            else
                return -1;
        }

        public void put(int key, int value) {
            ListNode newIN = new ListNode(key, value);

            //链表中已经有这个节点，则更新值和优先级
            if(map.containsKey(key)){
                map.get(key).val = value;
                //更新node的优先级
                moveToHead(head, map.get(key));
            }
            else {
                //如果map满了,要把优先度最低的节点删除，再插入新节点
                 if(map.size() == capacity) {
                    map.remove(head.previous.key);
                    ListNode lastNode = head.previous;
                    lastNode.previous.next = head;
                    head.previous = lastNode.previous;
                 }

                insertAfterHead(head, newIN);
                map.put(key, newIN);
            }
        }

        //将节点插到头结点后面，即优先级调到当前最高
        public void insertAfterHead(ListNode head, ListNode node){
            ListNode one = head.next;
            head.next = node;
            node.next = one;
            one.previous = node;
            node.previous = head;
        }

        //将原本就在链表中的节点插到头节点后
        public void  moveToHead(ListNode head, ListNode node){
            node.previous.next = node.next;
            node.next.previous = node.previous;
            insertAfterHead(head, node);
        }
    }

    public static void main(String[] args) {
        LRUCache lRUCache  = new LRUCache(2);
        lRUCache.put(2, 1); // 缓存是 {1=1}
        lRUCache.put(1, 1); // 缓存是 {1=1, 2=2}
        lRUCache.put(2, 3);
        lRUCache.put(4, 1);
        System.out.println(lRUCache.get(1));
        System.out.println(lRUCache.get(2));
    }
}
