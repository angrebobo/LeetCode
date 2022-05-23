package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:20 2022/5/23
 */
public class Offer_Num27 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            if(root == null)
                return null;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            mirrorTree(root.left);

            mirrorTree(root.right);

            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        Solution solution = new Solution();
        solution.mirrorTree(n1);
    }
}
