package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/26 15:54
 */

public class Num122 {
    //解法1，贪心
//    public static int maxProfit(int[] prices) {
//        int len = prices.length;
//        int ans = 0;
//
//        for (int i = 1; i < len; i++) {
//            if(prices[i] > prices[i-1])
//                ans += prices[i] - prices[i-1];
//            else continue;
//        }
//
//        return ans;
//    }

    //解法2，动态规划,空间优化
    public static int maxProfit(int[] prices){
//        int len = prices.length;
//        int[][] dp = new int[len][2];
//
//        dp[0][0] = 0;
//        dp[0][1] = -prices[0];
//
//        for (int i = 1; i < len; i++) {
//            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
//            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0]-prices[i]);
//        }
//        return dp[len-1][0];
        int len = prices.length;
        int dp0 = 0;
        int dp1 = -prices[0];
        int temp0, temp1;

        for (int i = 0; i < len; i++) {
            temp0 = Math.max(dp0, dp1 + prices[i]);
            temp1 = Math.max(dp1, dp0-prices[i]);
            dp0 = temp0;
            dp1 = temp1;
        }
        return dp0;
    }



    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
