package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:09 2022/5/23
 */
public class Num958 {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    static class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode pre = root;
            queue.add(root);
            while (!queue.isEmpty()){
                TreeNode temp = queue.poll();
                if(pre==null && temp!=null)
                    return false;

                if(temp != null){
                    queue.add(temp.left);
                    queue.add(temp.right);
                }

                pre = temp;
            }

            return true;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
        n3.left = n6;
        Solution solution = new Solution();
        System.out.println(solution.isCompleteTree(n1));
    }
}
