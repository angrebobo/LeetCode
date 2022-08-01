package LeetCode;

import java.util.*;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/3 10:32
 */

public class Num513 {

    private static List<Integer> list = new ArrayList<>();

    static class Solution {
        public int findBottomLeftValue(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int n;
            TreeNode res = null;

            while (!queue.isEmpty()){
                n = queue.size();

                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();

                    if(i == 0 )
                        res = node;

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
            }

            return res.val;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;

        Solution solution = new Solution();
        System.out.println(solution.findBottomLeftValue(n1));
    }
}
