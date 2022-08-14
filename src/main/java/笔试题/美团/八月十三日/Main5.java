package 笔试题.美团.八月十三日;

import java.util.Scanner;

/**
 * n个节点的二叉树，每个节点上有一定的金币，每次只选择左子树或者右子树的金币，问能拿到的最大金币数。
 */
public class Main5 {

    static int max = Integer.MIN_VALUE;
    public static void dfs(int[] nums, int index, int money){
        if(index >= nums.length)
            return;
        money += nums[index];
        max = Math.max(max, money);


        dfs(nums, index*2, money);


        dfs(nums, index*2+1, money);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        // 以后树的下标的题，数组设长一个，然后root从下标1开始，就能遵循左孩子index*2，右孩子index*2+1的规则了
        int[] nums = new int[n+1];
        nums[0] = 0;
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 1, 0);
        System.out.println(max);
    }
}
