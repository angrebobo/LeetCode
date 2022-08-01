package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:19 2022/8/1
 */
public class TreeNode {
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
