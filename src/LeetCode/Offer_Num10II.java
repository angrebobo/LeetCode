package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 18:43 2022/4/27
 */
public class Offer_Num10II {
    static class Solution {
        public int numWays(int n) {
            if(n==0||n==1) return 1;
            if(n==2) return 2;
            int[] dp = new int[n+1];
            dp[0] = 1; dp[1] = 1; dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%1000000007;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWays(4));
    }
}
