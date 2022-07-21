package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:24 2022/7/19
 */
public class Num96 {
    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i < n+1; i++) {
                for (int j = 0; j < i; j++) {
                    dp[i] += dp[j]*dp[i-j-1];
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}
