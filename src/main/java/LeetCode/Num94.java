package LeetCode;

import java.util.*;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/18 18:28
 */

public class Num94 {

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

    static class ColorNode {
        TreeNode node;
        boolean visited;

        public ColorNode(TreeNode node,boolean visited){
            this.node = node;
            this.visited = visited;
        }
    }
    //颜色标记法
    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        ArrayDeque<ColorNode> stack = new ArrayDeque<>();
        stack.push(new ColorNode(root,false));

        while(!stack.isEmpty()){
            ColorNode cn = stack.pop();

            if(!cn.visited){
                if(cn.node.right != null) stack.push(new ColorNode(cn.node.right,false));
                stack.push(new ColorNode(cn.node,true));
                if(cn.node.left != null) stack.push(new ColorNode(cn.node.left,false));
            }else{
                res.add(cn.node.val);
            }
        }

        return res;
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
        System.out.println(inorderTraversal(n1));
    }
}
