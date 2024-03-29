package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/28 19:28
 */

public class Num226 {

    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            reverse(root);
            return root;
        }

        public void reverse(TreeNode root){
            if(root == null)
                return;

            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            reverse(root.left);
            reverse(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left=n2;
        n1.right=n3;
        n2.left = n4;
        n2.right = n5;

        Solution solution = new Solution();
        System.out.println(solution.invertTree(n1));
    }
}
