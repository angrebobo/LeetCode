package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description: 求树的最大宽度
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
            if(root == null) return 1;
            Queue<TreeNode> queue = new LinkedList<>();
            //index记录节点的下标值
            LinkedList<Integer> index = new LinkedList<>();
            queue.add(root);
            index.add(1);
            int max = 1;
            int temp;
            int p;

            while ( !queue.isEmpty() ){
                temp = queue.size();
                for (int i = 0; i < temp; i++) {
                    TreeNode node = queue.poll();
                    p = index.pollFirst();
                    if(node.left != null){
                        queue.add(node.left);
                        index.addLast(p*2);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                        index.addLast(p*2+1);
                    }
                }
                if(index.size() >= 2)
                    max = Math.max(max, index.getLast() - index.getFirst() + 1);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        /*TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        n4.left = n6;
        n5.left = n7;*/

        Solution solution = new Solution();
        System.out.println(solution.widthOfBinaryTree(n1));
    }
}
