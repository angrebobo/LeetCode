package 笔试题.小红书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 小明的旅途中需要经过一个国家。这个国家有n个城市，编号为1到n。小明会从1号城市进入，
 * 目标是从n号城市出去（即要从1号城市到达n号城市）。有m条双向道路连接这n个城市，每条道路的长度都是1，
 * 并且都有一个过路费（是[1,100000]之间的整数）。当小明在1号城市时他可以预先花费X的费用办一张特权卡，
 * 他可以获得所有过路费不超过X的道路的通行权（而其他道路无法通过）。小明一天最多只能走k长度的路，
 * 他想知道如果他想在一天之内从1号城市到n号城市，他最少需要花费多少来办特权卡，即求X的最小值？
 * 第一行是3个整数n，m，k，分别表示城市数，道路数和小明一天最多能走的长度
 * 第二行m个整数，分别为u1, u2...um，分别表示第i条道路的一个端点。
 * 第三行m个整数，分别为v1, v2...vm，分别表示第i条道路的另一个端点。
 * 第四行m个整数，分别为w1, w2...wm，分别表示第条道路的过路费
 * 数字间两两有空格隔开。数据保证一定存在解
 * 输出描述
 * 一行一个整数，表示X的最小值
 *
 * input:
 * 5 5 3
 * 1 1 2 3 4
 * 2 5 3 4 5
 * 2 5 2 2 2
 *
 * output:
 * 5
 *
 * @Data: Created in 15:30 2022/9/4
 */
public class Main3 {

    static int count;
    public static void dfs(int[][] edge, int cur, int begin, boolean[] visit, int money, int n){
        if(cur >= count)
            return;


        int[] path = edge[begin];
        for (int i = 1; i < path.length; i++) {
            if(!visit[i] && path[i] != 0 && path[i]<=money){
                visit[i] = true;
                dfs(edge, cur+1, i, visit, money, n);
                if(visit[n])
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0){
            System.out.println(0);
            return;
        }
        int m = sc.nextInt();
        count = sc.nextInt();

        int[][] edge = new int[n+1][n+1];
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;

        int[] temp1 = new int[m];
        for (int i = 0; i < m; i++) {
            temp1[i] = sc.nextInt();
        }
        int[] temp2 = new int[m];
        for (int i = 0; i < m; i++) {
            temp2[i] = sc.nextInt();
        }
        int[] temp3 = new int[m];
        for (int i = 0; i < m; i++) {
            temp3[i] = sc.nextInt();
            minVal = Math.min(minVal, temp3[i]);
            maxVal = Math.max(maxVal, temp3[i]);

            edge[temp1[i]][temp2[i]] = edge[temp2[i]][temp1[i]] = temp3[i];
        }

        boolean[] visit = new boolean[n+1];
        visit[1] = true;

        for (int i = minVal; i <= maxVal; i++) {
            dfs(edge, 0, 1, visit, i, n);
            if(visit[n]){
                System.out.println(i);
                break;
            }
            else {
                Arrays.fill(visit, false);
                visit[1] = true;
            }
        }
    }
}
