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
       int[] dp = new int[10];
        System.out.println(dp[5]);

    }
}


