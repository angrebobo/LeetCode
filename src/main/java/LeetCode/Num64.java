package LeetCode;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/16 23:48
 **/
public class Num64 {

    static class Solution {
        public int minPathSum(int[][] grid) {
            int m = grid[0].length;
            int n = grid.length;
            int[][] dp = new int[n][m];
            dp[0][0] = grid[0][0];
            //初始化
            for (int i = 1; i < m; i++) {
                dp[0][i] = dp[0][i-1] + grid[0][i];
            }
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i-1][0] + grid[i][0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }

            return dp[n-1][m-1];
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        Solution solution = new Solution();
        System.out.println(solution.minPathSum(grid));
    }
}
