package 笔试题.小马智行;

import java.util.Scanner;

public class Main2 {

    static int max;
    static int[][] nums;
    static int[][] ways;
    public static void dfs(int i, int j, int pathLen, boolean[][] visited){
        max = Math.max(max, pathLen);
        int nextI = i + ways[nums[i][j]][0];
        int nextJ = j + ways[nums[i][j]][1];
        if(check(nextI, nextJ) && !visited[nextI][nextJ]){
            visited[nextI][nextJ] = true;
            dfs(nextI, nextJ, pathLen+1, visited);
        }
    }

    // 检查下一步是否能走
    public static boolean check(int i, int j){
        if(i < 0 || i >= nums.length || j<0 || j>=nums[0].length)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ways = new int[4][2];
        // 上下左右
        ways[0] = new int[]{-1,0};
        ways[1] = new int[]{1,0};
        ways[2] = new int[]{0,-1};
        ways[3] = new int[]{0,1};

        int n  = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        nums = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if(s.charAt(j)=='^')
                    nums[i][j] = 0;
                else if(s.charAt(j)=='v')
                    nums[i][j] = 1;
                else if(s.charAt(j)=='<')
                    nums[i][j] = 2;
                else if(s.charAt(j)=='>')
                    nums[i][j] = 3;
            }
        }

        boolean[][] visited;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = 0;
                visited = new boolean[n][m];
                visited[i][j] = true;
                dfs(i, j, 1, visited);
                ans = Math.max(ans, max);
            }
        }
        System.out.println(ans);
    }
}
