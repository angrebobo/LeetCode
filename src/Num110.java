/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/7 19:39
 */

public class Num110 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public boolean isBalanced(TreeNode root) {
            return dfs(root) != -1;
        }

        public int dfs(TreeNode root){
            if(root == null)
                return 0;

            int left = dfs(root.left);
            if(left == -1) return -1;

            int right = dfs(root.right);
            if(right == -1) return -1;

            return Math.abs(left-right) < 2 ? Math.max(left, right)+1 : -1;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);

        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(n1));
    }
}
