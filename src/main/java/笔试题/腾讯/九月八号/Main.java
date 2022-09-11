package 笔试题.腾讯.九月八号;

import LeetCode.TreeNode;

/**
 * @author: HuangSiBo
 * @Description:
 * 给定一棵二叉树，二叉树的每个结点只有0或2个孩子。
 * 你需要对每个结点赋值一个正整数，使得每个结点的左右子树权值和相等。
 * 你需要返回所有结点的最小权值和，并对1e9+7取模的结果。
 * 二叉树结点个数不超过1e5。
 * @Data: Created in 0:02 2022/9/11
 */
public class Main {

    public static int traverse(TreeNode root){
        if(root == null)
            return 0;

        long res = Math.max(traverse(root.left), traverse(root.right))* 2L + 1;
        res %= Math.pow(10, 9)+7;

        return (int) res;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);

        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
//        n3.left = n6;n3.right = n7;

        System.out.println(traverse(n1));
    }
}
