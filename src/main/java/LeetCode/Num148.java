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


    public static ListNode1 sortList(ListNode1 head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode1 fast = head.next;
        ListNode1 slow = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode1 tmp = slow.next;
        slow.next = null;
        ListNode1 left =  sortList(head);
        ListNode1 right = sortList(tmp);
        return mergeTwoLists(left, right);
    }

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
        ListNode1 n1 = new ListNode1(4);
        ListNode1 n2 = new ListNode1(2);
        ListNode1 n3 = new ListNode1(1);
        ListNode1 n4 = new ListNode1(3);
        ListNode1 n5 = new ListNode1(5);
        ListNode1 n6 = new ListNode1(0);
        ListNode1 n7 = new ListNode1(7);
        ListNode1 n8 = new ListNode1(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        ListNode1 ans = sortList(n1);
        while (ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }

}
