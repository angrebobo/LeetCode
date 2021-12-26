import java.beans.beancontext.BeanContext;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/31 13:51
 */

public class Num111 {

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
        public int minDepth(TreeNode root) {
            if(root == null)
                return 0;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int depth = 0;

            while (!queue.isEmpty()){
                depth++;
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();

                    if(node.left==null && node.right==null)
                        return depth;

                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        Solution solution = new Solution();
        System.out.println(solution.minDepth(n1));
    }
}
