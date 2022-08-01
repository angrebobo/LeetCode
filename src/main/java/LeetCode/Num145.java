package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/11 21:38
 */

public class Num145 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        return list;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
    }
}
