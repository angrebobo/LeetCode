package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 13:24 2022/4/12
 */
public class Num98 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }



    static class Solution {
        Long preValue = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {
            if(root == null)
                return true;

            boolean isLeftBST = isValidBST(root.left);
            if(!isLeftBST)
                return false;
            if(preValue >= root.val)
                return false;
            preValue = (long) root.val;

            return  isValidBST(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(1);
        n1.left = n2;n1.right = n5;
        n2.left = n3;n2.right = n4;
        n5.left = n6;

        Solution solution = new Solution();
        System.out.println( solution.isValidBST(n1) );
    }
}
