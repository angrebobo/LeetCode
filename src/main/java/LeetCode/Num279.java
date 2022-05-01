package LeetCode;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/27 15:41
 **/
public class Num279 {

    static class Solution {
        //动态规划
        /*public int numSquares(int n) {
            int[] dp = new int[n+1];
            for (int i = 0; i < n+1; i++) {
                dp[i] = i;
                for (int j = 1; i-j*j >= 0; j++) {
                    dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                }
            }
            return dp[n];
        }*/

        //dfs
        public int numSquares(int n){
            if(n == 0)
                return 0;
            int count = Integer.MAX_VALUE;
            for (int i = 1; n-i*i >= 0; i++) {
                count = Math.min(count, numSquares(n-i*i)+1);
            }

            return count;
        }
    }

    public static void main(String[] args) {
        int n = 12;
        Solution solution = new Solution();
        System.out.println(solution.numSquares(n));
    }
}
