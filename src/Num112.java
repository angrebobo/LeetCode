import java.util.DuplicateFormatFlagsException;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/29 18:59
 */

public class Num112 {

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

         //解法1
        /*public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, 0, targetSum);
        }

        public  boolean dfs(TreeNode root,int plus, int target){
            if(root == null)
                return false;
            plus += root.val;
            if(plus == target && root.left==null && root.right==null)
                return true;

            return dfs(root.left, plus, target) || dfs(root.right, plus, target);
        }*/

        //解法2
         public boolean hasPathSum(TreeNode root, int targetSum) {
             if(root == null)
                 return false;
             if(root.val==targetSum && root.right==null && root.left==null)
                 return true;

             return hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val);
         }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(11);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(2);
        n1.left=n2;
        n2.left=n3;
        n3.left=n4;
        n3.right=n5;

        Solution solution = new Solution();
        System.out.println(solution.hasPathSum(n1, 22));
    }
}
