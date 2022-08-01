package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/11 20:34
 */

public class Num144 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        pre(list, root);
        return list;
    }

    private static void pre(List<Integer> list, TreeNode root){
        if(root == null)
            return ;

        list.add(root.val);
        pre(list, root.left);
        pre(list, root.right);
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
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        System.out.println(preorderTraversal(n1));
    }

}
