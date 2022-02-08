package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/11 21:38
 */

public class Num145 {
    static class TreeNode {
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

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public static void main(String[] args) {
        Num144.TreeNode n1 = new Num144.TreeNode(1);
        Num144.TreeNode n2 = new Num144.TreeNode(2);
        Num144.TreeNode n3 = new Num144.TreeNode(3);
        Num144.TreeNode n4 = new Num144.TreeNode(4);
        Num144.TreeNode n5 = new Num144.TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
    }
}
