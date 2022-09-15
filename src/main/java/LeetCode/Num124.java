package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 * 题解：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
 * @Data: Created in 14:37 2022/3/16
 */
public class Num124 {

    static class Solution {
        // 定义全局最大值
        static int max;

        public int maxPathSum(TreeNode root) {
            DFS(root);
            return max;
        }

        public int DFS(TreeNode root){
            // 若当前节点为空，当前节点能提供的最大值即0
            if(root == null)
                return 0 ;

            // 计算当前节点左子树能提供的最大值
            int left = DFS(root.left);
            // 计算当前节点右子树能提供的最大值
            int right = DFS(root.right);
            // 当前子树内部的最大路径和=当前节点值+当前节点左子树能提供的最大值+当前节点右子树能提供的最大值
            max = Math.max(max, root.val + left + right);

            // 计算当前子树对外提供的最大路径和（返回出来给父节点）
            int sum = root.val + Math.max(left, right);
            return Math.max(sum, 0);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(-5);
        TreeNode n5 = new TreeNode(100);
        TreeNode n6 = new TreeNode(-10);
        TreeNode n7 = new TreeNode(9);
        TreeNode n8 = new TreeNode(7);
        n1.left = n2;
        n2.left = n3;
        n1.right = n4;
        n4.left = n5;
        n4.right = n7;
        n5.left  =n6;
        n7.right = n8;

        Solution solution = new Solution();
        System.out.println(solution.maxPathSum(n1));
    }

}
