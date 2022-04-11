package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:33 2022/4/11
 */
public class Num662 {

    static public class TreeNode {
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
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null) return 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int max = 0;
            int temp;

            while (!queue.isEmpty()){
                temp = queue.size();
                max = Math.max(max, temp);
                for (int i = 0; i < temp; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                }
                System.out.println();
            }
            return max;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;
        n3.right = n6;
        n5.left = n7;

        Solution solution = new Solution();
        System.out.println(solution.widthOfBinaryTree(n1));
    }
}
