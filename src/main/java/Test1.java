import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 思路：从根节点开始向下遍历，如果当前根节点
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


        while (check(root.left) && check(root.right)){
            dfs(root.left);
            dfs(root.right);
            ans++;
        }

        count(root.left);
        count(root.right);
    }


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
