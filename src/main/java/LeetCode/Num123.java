package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * 题解：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/solution/tong-su-yi-dong-de-dong-tai-gui-hua-jie-fa-by-marc/
 * @data: 2021/4/26 17:15
 */

public class Num123 {

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金
        int[][][] dp = new int[len][2][3];
        int MIN_VALUE = Integer.MIN_VALUE / 2;
        dp[0][0][0] = 0;
        // 不存在这种情况
        dp[0][0][1] = MIN_VALUE;
        // 不存在这种情况
        dp[0][0][2] = MIN_VALUE;
        dp[0][1][0] = -prices[0];
        // 不存在这种情况
        dp[0][1][1] = MIN_VALUE;
        // 不存在这种情况
        dp[0][1][2] =MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Math.max(dp[i-1][1][0]+prices[i], dp[i-1][0][1]);
            dp[i][0][2] = Math.max(dp[i-1][1][1]+prices[i], dp[i-1][0][2]);
            dp[i][1][0] = Math.max(dp[i-1][0][0]-prices[i], dp[i-1][1][0]);
            dp[i][1][1] = Math.max(dp[i-1][0][1]-prices[i], dp[i-1][1][1]);
            dp[i][1][2] = MIN_VALUE;
        }
        return Math.max(0, Math.max(dp[len-1][0][1], dp[len-1][0][2]));
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(prices));
    }

}
