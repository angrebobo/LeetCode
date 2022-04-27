package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 18:28 2022/4/27
 */
public class Offer_Num10 {
    class Solution {
        public int fib(int n) {
            if(n==0) return 0;
            if(n==1) return 1;
            int[] dp = new int[n+1];
            dp[0] = 0;dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i-1] + dp[i-2])%1000000007;
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {

    }
}
