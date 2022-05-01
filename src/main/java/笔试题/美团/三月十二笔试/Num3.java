package 笔试题.美团.三月十二笔试;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 小美现在在厨房做饭。小美发现食材现在只够每种菜做一份。现在同一时刻（即不分先后顺序）来了n个顾客。每个顾客都有想两份要点的菜。只有当顾客吃到全部自己想要的菜的时候，顾客才会满意。
 * 现在你的任务是，合理地接取顾客的订单要求，尽可能让更多的顾客满意，并输出最多有多少顾客可以满意。
 *
 * 输入描述
 * 第一行两个正整数n, m
 * n表明有多少顾客前来点菜，m表示小美现在能做的菜的编号范围在[1, m]。
 * 接下来n行，每行两个数字，表明一名顾客的所点的两道菜的编号。
 * 其中80% 的数据保证2 <= n <= 10, 2 <= m <= 20
 * 另外20 % 的数据保证2 <= n <= 20, 2 <= m <= 40
 *
 * 作者：追月无痕
 * 链接：https://leetcode-cn.com/circle/discuss/6qBxqq/
 * @Data: Created in 14:39 2022/4/15
 */
public class Num3 {
    static int[] N = new int[20];
    static int[] M = new int[40];
    static int n,m;
    static int[] visited;
    static int ans = 0;

    public static void dfs(int index, int num){
        if(index == n){
            ans = Math.max(ans, num);
            return;
        }

        if(visited[N[index]]==0 && visited[M[index]]==0){
            visited[N[index]] = 1;
            visited[M[index]] = 1;
            dfs(index + 1, num+1);
            visited[N[index]] = 0;
            visited[M[index]] = 0;
        }
        dfs(index+1, num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited= new int[m+1];
        for (int i = 0; i < n; i++) {
            N[i] = sc.nextInt();
            M[i] = sc.nextInt();
        }
        dfs(0, 0);
        System.out.println(ans);

    }
}
