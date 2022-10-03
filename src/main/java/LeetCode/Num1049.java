package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * // 将这些数字分成两拨，使得他们的和的差最小
 * @Data: Created in 19:27 2022/10/3
 */
public class Num1049 {
    static class Solution {
        public int lastStoneWeightII(int[] stones) {
            int sum = 0;
            for (int stone : stones) {
                sum += stone;
            }
            int bagSize = sum/2;
            int len = stones.length;
            int[][] dp = new int[len][bagSize+1];
            for (int j = 0; j <= bagSize; j++) {
                if(j>=stones[0])
                    dp[0][j] = stones[0];
            }

            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= bagSize; j++) {
                    if(j >= stones[i]){
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-stones[i]]+stones[i]);
                    }
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }

            return sum-2*dp[len-1][bagSize];
        }
    }

    public static void main(String[] args) {
        int[] stones = new int[]{1,2};
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeightII(stones));
    }
}
