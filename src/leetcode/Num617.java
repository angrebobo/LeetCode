package leetcode;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/8/28 20:07
 */

public class Num617 {

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
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if(root1==null || root2==null)
                return root1==null ? root2 : root1;

            merge(root1, root2);
            return root1;
        }

        /**
         * @Description 返回值是int是为了方便判断root1==null&&root2!=null这种情况，需要返回后新建节点
         * @param
         * @return
         */
        public int merge(TreeNode root1, TreeNode root2){
            if(root1!=null && root2!=null)
                root1.val = root1.val + root2.val;
            // 需要返回到上一步
            else if(root1==null && root2!=null)
                return 1;
            else
                return 0;

            int left = merge(root1.left, root2.left);
            if(left == 1)
                root1.left = root2.left;
            int right = merge(root1.right, root2.right);
            if(right == 1)
                root1.right = root2.right;

            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(4);
        TreeNode n9 = new TreeNode(7);
        n1.left = n2;
        //n1.right = n3;
        n2.left = n3;
//        n5.left = n6;
//        n5.right = n7;
//        n6.right = n8;
//        n7.right = n9;
        n4.right = n5;
        n5.right = n6;

        Solution solution = new Solution();
        solution.mergeTrees(n1, n4);
    }
}
