package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/27 21:05
 */

public class Num104 {

    public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return Math.max(maxDepth(root.left)+1, maxDepth(root.right)+1);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        n1.left = n2;
        System.out.println(maxDepth(n1));
    }
}
