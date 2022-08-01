package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 该题的关键在于二叉搜索树的中序遍历是升序的
 * @Data: Created in 10:00 2022/5/23
 */
public class Num783 {

    static class Solution {
        static int preValue;
        static int minValue;

        public int minDiffInBST(TreeNode root) {
            preValue = -1;
            minValue = Integer.MAX_VALUE;

            recursion(root);
            return minValue;
        }

        public void recursion(TreeNode root){
            if (root == null)
                return;

            recursion(root.left);

            // preValue==-1，说明当前root是二叉树的最左下角节点，当前root在中序遍历中排第一，因此跳过
            if(preValue != -1)
                minValue = Math.min(minValue, Math.abs(preValue - root.val));

            preValue = root.val;
            recursion(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(27);
        TreeNode n2 = new TreeNode(34);
        TreeNode n3 = new TreeNode(58);
        TreeNode n4 = new TreeNode(50);
        TreeNode n5 = new TreeNode(44);
        n1.right = n2;
        n2.right = n3;
        n3.left = n4;
        n4.left = n5;

        Solution solution = new Solution();
        System.out.println( solution.minDiffInBST(n1) );
    }
}
