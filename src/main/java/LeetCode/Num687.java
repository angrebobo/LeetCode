package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/1 10:20
 */

public class Num687 {

    /*static class Solution {
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
    }*/

    static int max;
    public static int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        max = 0;
        dfs(root);
        return max-1;
    }

    public static int dfs(TreeNode root){
        if(root == null)
            return 0;

        int left = 0, right = 0;
        if(root.left!=null){
            left = dfs(root.left);
            if(root.val != root.left.val){
                left = 0;
            }
        }
        if(root.right!=null){
            right= dfs(root.right);
            if(root.val != root.right.val){
                right = 0;
            }
        }

        int temp = 1 + left + right;
        max = Math.max(max, temp);
        return temp;
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

//        Solution solution = new Solution();
//        System.out.println(solution.longestUnivaluePath(n1));

        System.out.println(longestUnivaluePath(n1));
    }
}
