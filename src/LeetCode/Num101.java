package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/7 20:26
 */

public class Num101 {
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

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null)
            return true;
        else if(root.left==null || root.right==null) //左右节点有一个为null
            return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();

            if(n1==null && n2==null)
                continue;
            else if(n1==null || n2==null) //其中有一个为null
                return false;
            else if(n1.val != n2.val)
                return false;

            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(3);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(4);
        n1.left=n2;n1.right=n3;
        n2.left=n4;n2.right=n6;
        //n3.left=n7;
        n3.right=n5;
        System.out.println(isSymmetric(n1));
    }
}
