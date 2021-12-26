/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/7/17 19:19
 */

public class Num300 {

    public static int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        int ans = -1;

        for (int i = 0; i <= len-1; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i] && dp[j]+1>dp[i])
                    dp[i] = dp[j] + 1;
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }



    /**
     * @Description 2021.10.06写
     * @param
     * @return
     */
    static class Solution {
        public int lengthOfLIS(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            int max = 0;

            for (int i = 0; i < len; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if(nums[i] > nums[j]){
                        dp[i] = Math.max(dp[j]+1, dp[i]);
                    }
                }
                max = Math.max(dp[i], max);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,2,3};
        //System.out.println(lengthOfLIS(nums));
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}
