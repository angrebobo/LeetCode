/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/28 19:21
 */

public class Num543 {

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

    //解法1
    static class Solution {
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            depth(root);

            return ans;
        }

        public int depth(TreeNode root){
            if(root == null)
                return 0;

            int left = depth(root.left);
            int right = depth(root.right);
            ans = Math.max(ans, left+right);
            return Math.max(left, right) + 1;
        }
    }

    //解法2
    /*static class Solution {

        public int diameterOfBinaryTree(TreeNode root) {
            if(root==null) return 0;
            int len = depth(root.left) + depth(root.right);
            int left = diameterOfBinaryTree(root.left);
            int right = diameterOfBinaryTree(root.right);
            return len>left ? (len>right ? len : right) : (left>right? left : right);
        }

        public int depth(TreeNode root){
            if(root == null)
                return 0;

            return Math.max(depth(root.left)+1, depth(root.right)+1);
        }
    }*/

    public static void main(String[] args) {

    }
}
