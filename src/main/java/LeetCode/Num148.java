package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:01 2021/7/7
 */
public class Num148 {
    /*public static ListNode sortList(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        while (p != null){
            map.put(p, p.val);
            p = p.next;
        }
        // 对map进行排序
        HashMap<ListNode, Integer> ans = sortHashmap(map);
        ListNode dummy = new ListNode();
        p = dummy;
        for(ListNode key : ans.keySet()){
            key.next = null;
            ListNode temp = key;
            p.next = temp;
            p = temp;
        }
        return dummy.next;
    }

    *//**
     * @Description 对map进行排序
     * @param
     * @return
     *//*
    private static HashMap<ListNode, Integer> sortHashmap(HashMap<ListNode, Integer> map){
        Set<Map.Entry<ListNode, Integer>> entrySet = map.entrySet();
        List<Map.Entry<ListNode, Integer>> list =  new ArrayList<>(entrySet);
        Collections.sort(list, (o1, o2) -> o1.getKey().val-o2.getKey().val);
        LinkedHashMap<ListNode, Integer> LinkedHashMap = new LinkedHashMap<>();
        for(Map.Entry<ListNode, Integer> entry : list){
            LinkedHashMap.put(entry.getKey(), entry.getValue());
        }
        return LinkedHashMap;
    }*/


    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left =  sortList(head);
        ListNode right = sortList(tmp);
        return mergeTwoLists(left, right);
    }

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
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(0);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        ListNode ans = sortList(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}
