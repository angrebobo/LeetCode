package LeetCode;


import javax.security.auth.login.Configuration;
import java.util.Arrays;

/**
 * @Description TODO
 * @Author HuangSiBo
 * @Date 2022/2/13 15:33
 * 题解：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 **/
public class Num322 {

    public static class Solution {
        public int coinChange(int[] coins, int amount) {
            int len = coins.length;
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < len; j++) {
                    if(coins[j] <= i){
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    }
                }
            }

            return dp[amount] != (amount+1) ? dp[amount] : -1;
        }
    }

    public static void main(String[] args) {
        int[] conis = new int[]{2};
        int amount = 3;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(conis, amount));
    }
}
