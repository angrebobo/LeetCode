package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/1 10:20
 */

public class Num687 {

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
        int ans;
        public int longestUnivaluePath(TreeNode root) {
            ans = 0;
            arrowLength(root);
            return ans;
        }
        public int arrowLength(TreeNode node) {
            if (node == null) return 0;
            int left = arrowLength(node.left);
            int right = arrowLength(node.right);
            int arrowLeft = 0, arrowRight = 0;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft += left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                arrowRight += right + 1;
            }
            ans = Math.max(ans, arrowLeft + arrowRight);
            return Math.max(arrowLeft, arrowRight);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;
        n6.left = n7;

        Solution solution = new Solution();
        System.out.println(solution.longestUnivaluePath(n1));
    }
}
