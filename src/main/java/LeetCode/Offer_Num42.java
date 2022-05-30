package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 16:48 2022/5/30
 */
public class Offer_Num42 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = dp[0];

            for (int i = 1; i < len; i++) {
                if(dp[i-1] > 0)
                    dp[i] = dp[i-1] + nums[i];
                else
                    dp[i] = nums[i];
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,4,-1,7,8};

        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
