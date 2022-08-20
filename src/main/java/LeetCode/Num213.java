package LeetCode;

public class Num213 {

    static class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if(len == 0) return 0;
            if(len == 1) return nums[0];
            // dp[i]表示从前i间房能偷到最多的钱

            // 偷第一个房间
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = nums[0];
            for (int i = 2; i < len; i++) {
                if(i == len-1)
                    dp[i] = dp[i-1];
                else
                    dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            }
            int max = dp[len-1];


            // 不偷第一个房间
            int[] dp1 = new int[len];
            dp1[0] = 0;
            dp1[1] = nums[1];
            for (int i = 2; i < len; i++) {
                dp1[i] = Math.max(dp1[i-1], dp1[i-2]+nums[i]);
            }
            max = Math.max(max, dp1[len-1]);


            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,2};
        Solution solution = new Solution();
        System.out.println(solution.rob(nums));
    }
}
