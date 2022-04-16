package 面试题.美团.三月十二笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 小美现在打音游。这个音游的玩法是这样的：
 * —— 共有n个房间。小美初始拥有一个指针，指在一号房间。
 * —— 游戏共持续m秒，每秒会有一个房间产生炸弹，小美的指针不能在这个房间中。
 * —— 每秒结束的瞬间，小美可以使用一次魔法，把指针切换到另一个房间中，该过程会消耗一个能量。
 * 你的任务是计算小美无伤通过音游所需要消耗的最小能量。
 * 保证第一秒的炸弹不发生在一号房间中。
 * n ＜ = 10, 1 <= m <= 10000
 * 输入描述：
 * 第一行两个正整数 n 和 m，表示房间有 n 个，游戏持续 m 秒。
 * 第二行 m 个正整数，每个正整数在1~n 的范围内，第 i 个正整数表示第 i 秒时炸弹在哪个房间生成。
 * 数字间有空格隔开
 * 样例输入
 * 2 4
 * 2 1 1 2
 * 样例输出
 * 2
 * @Data: Created in 15:10 2022/4/15
 */
public class Num4 {

    static int n,m;
    static int[] bombs;
    static int ans = Integer.MAX_VALUE;

    public static void dfs(int index, int energy, int second){
        if(second == m+1){
            ans = Math.min(ans, energy);
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(i != bombs[second]){
                dfs(i, energy + (i == index?0:1), second+1);
            }
        }
    }

    public static int dp(){
        int[][] dp = new int[m+1][n+1];
        for(int[] d : dp){
            Arrays.fill(d,m+1);
        }
        dp[1][1] = 0;
        //在第i秒
        for (int i = 2; i <= m; i++) {
            //在第j个房间
            for (int j = 1; j <= n; j++) {
                //第i秒j房间要炸了，不跳到j这
                if(bombs[i] == j)
                    continue;
                //要跳到j房间，更新状态，第i-1秒从k房间跳过来
                for (int k = 1; k <= n; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + (j==k?0:1));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, dp[m][i]);
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        bombs = new int[m+1];
        for (int i = 1; i <= m; i++) {
            bombs[i] = sc.nextInt();
        }
        dfs(1, 0, 1);
        System.out.println("dfs: " + ans);

        System.out.println("dp: " + dp());
    }
}
