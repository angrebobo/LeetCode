package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/9/3 10:19
 */

public class Num637 {

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
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> res = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int n;
            double sum;

            while (!queue.isEmpty()){
                n = queue.size();
                sum = 0;
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                res.add(sum/n);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;

        Solution solution = new Solution();
        System.out.println(solution.averageOfLevels(n1));
    }
}
