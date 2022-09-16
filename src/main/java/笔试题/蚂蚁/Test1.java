package 笔试题.蚂蚁;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：
 * N个节点的树，根节点编号为1。
 * 最开始，树上所有节点的值都为1。
 * 你可以进行如下操作，选择一个子树，让子树的所有节点的值+1.
 * 问，最少需要多少次操作才可以让每个节点的值等于其编号。
 * 输入：
 * 3
 * 1 2
 * 1 3
 * 输出：
 * 3
 *
 *
 * 思路：从上到下遍历，在越高的节点选子树加1，整体加的次数就越小
 * @Data: Created in 19:51 2022/9/15
 */
public class Test1 {

    static class TreeNode {
        public int num;
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int num ,int val) {
            this.num = num;
            this.val = val;
        }
    }

    static int ans = 0;
    public static void count(TreeNode root){
        if(root == null)
            return;

        if(root.left == null && root.right==null){
            ans += root.num-root.val;
            root.val = root.num;
            return;
        }


        while( check(root.left) ){
            dfs(root.left);
            ans++;
        }

        while( check(root.right) ){
            dfs(root.right);
            ans++;
        }

        count(root.left);
        count(root.right);
    }

    // 判断以root为根的树能否整体加1
    public static boolean check(TreeNode root){
        if(root == null)
            return true;

        if(root.left==null && root.right==null){
            return root.val + 1 <= root.num;
        }

        if(root.val + 1 > root.num)
            return false;

        boolean left = check(root.left);
        if(!left)
            return false;
        return check(root.right);
    }

    // 以root为根的树整体加1
    public static void dfs(TreeNode root){
        if(root == null)
            return;
        root.val+=1;
        dfs(root.left);
        dfs(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        TreeNode[] nodes = new TreeNode[n+1];
        // 输入中，没有给出左右子树的关系
        // 所以count用来记录一个几点的次数
        // 第一次出现时，是父亲和左子
        // 第二次出现时，是父亲和右子树
        int[] count = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(nodes[a]==null)
                nodes[a] = new TreeNode(a,1);
            if(nodes[b]==null)
                nodes[b] = new TreeNode(b,1);
            if(count[a] == 0){
                nodes[a].left = nodes[b];
                count[a]++;
            }
            else if(count[a] == 1){
                nodes[a].right = nodes[b];
            }
        }

        count(nodes[1]);
        System.out.println(ans);
    }
}
