package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:50 2022/5/23
 */
public class Num230 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        static int res;
        static int count;
        public int kthSmallest(TreeNode root, int k) {
            res = 0;
            count = 1;
            dfs(root, k);
            return res;
        }

        public void dfs(TreeNode root, int k){
            if(root == null || count > k)
                return;

            dfs(root.left, k);
            if(count == k)
                res = root.val;
            count++;
            dfs(root.right, k);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);
        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        Solution solution = new Solution();
        System.out.println(solution.kthSmallest(n1, 2));
    }
}
