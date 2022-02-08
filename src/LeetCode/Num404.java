package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/1 10:01
 */

public class Num404 {

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
        int sum = 0;

        public int sumOfLeftLeaves(TreeNode root) {
            dfs(root);
            return sum;
        }

        public boolean dfs(TreeNode root){
            //防止整棵树没有左节点的情况
            if(root == null)
                return false;
            //如果是叶子节点，返回true
            if(root.left==null && root.right==null)
                return true;

            boolean left = dfs(root.left);
            //如果是左叶子节点，加到sum上
            if(left)
                sum += root.left.val;
            boolean right = dfs(root.right);

            return false;
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
        System.out.println(solution.sumOfLeftLeaves(n1));
    }

}
