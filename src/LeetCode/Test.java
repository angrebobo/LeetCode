package LeetCode;


import java.nio.IntBuffer;

/**
 * @Description TODO
 * @Author HuangSiBo
 * @Date 2022/2/13 18:25
 **/
public class Test {

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

    public static void dfs(TreeNode n){
        if(n == null)
            return;
        System.out.println(n.val);
        dfs(n.left);
        dfs(n.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;n1.right = n3;
        n2.left = n4;
        n3.left = n5;n3.right = n6;
        n4.left = n7;n4.right = n8;
        n6.left = n9;n6.right = n10;

        dfs(n1);

    }
}


