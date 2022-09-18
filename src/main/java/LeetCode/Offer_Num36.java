package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:16 2022/5/25
 */
public class Offer_Num36 {
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) { this.val = val; }
    }

    /*static class Solution {
        public Node treeToDoublyList(Node root) {
            if(root == null) return null;
            List<Node> list = new LinkedList<>();
            recursion(root, list);
            int len = list.size();
            for (int i = 0; i < len; i++) {
                list.get(i).left = list.get( (i-1+len)%len );
                list.get(i).right = list.get( (i+1+len)%len );
            }

            return list.get(0);
        }

        // 二叉搜索树的中序遍历时递增的
        public void recursion(Node root, List<Node> list){
            if(root == null)
                return;

            recursion(root.left, list);

            list.add(root);

            recursion(root.right, list);
        }
    }*/

    static class Solution {

        static Node pre;
        static Node mostLeft;
        public Node treeToDoublyList(Node root) {
            if(root == null)
                return null;
            pre = null;
            InOrderTraverse(root);
            mostLeft.left = pre;
            pre.right = mostLeft;
            return mostLeft;
        }

        public void InOrderTraverse(Node root){
            if(root == null)
                return;

            InOrderTraverse(root.left);
            if(pre == null){
                mostLeft = root;
            }
            else {
                root.left = pre;
                pre.right = root;
            }
            pre = root;
            InOrderTraverse(root.right);
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(4);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        Node n4 = new Node(3);
        Node n5 = new Node(5);
        n1.left = n2;n1.right = n5;
        n2.left = n3;n2.right = n4;

        Solution solution = new Solution();
        System.out.println(solution.treeToDoublyList(n1).val);
    }
}
