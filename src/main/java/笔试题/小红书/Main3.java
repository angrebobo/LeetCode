package 笔试题.小红书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:30 2022/9/4
 */
public class Main3 {

    static int count;
    public static void dfs(int[][] edge, int cur, int begin, boolean[] visit, int money, int n){
        if(cur >= count)
            return;
        if(visit[n])
            return;


        int[] path = edge[begin];
        for (int i = 1; i < path.length; i++) {
            if(!visit[i] && path[i] != 0 && path[i]<=money){
                visit[i] = true;
                dfs(edge, cur+1, i, visit, money, n);
                visit[i] = false;
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
        }
        for (int i = 0; i < m; i++) {
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
