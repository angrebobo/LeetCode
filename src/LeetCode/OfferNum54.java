package LeetCode;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:06 2022/4/26
 */
public class OfferNum54 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public int kthLargest(TreeNode root, int k) {

            int count = 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode p = root;
            while (p!=null || !stack.isEmpty()){
                if(p != null){
                    stack.push(p);
                    p = p.right;
                }
                else {
                    p = stack.pop();
                    if(++count == k)
                        return p.val;
                    p = p.left;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;n2.right = n4;n1.right = n3;

        Solution solution = new Solution();
        System.out.println(solution.kthLargest(n1, 2));
    }
}
