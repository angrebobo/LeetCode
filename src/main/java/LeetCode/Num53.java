package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:54 2022/9/1
 */
public class Num53 {
    static class Solution {
        public int maxSubArray(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = nums[0];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = {1};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}
