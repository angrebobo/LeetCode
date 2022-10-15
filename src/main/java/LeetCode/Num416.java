package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 这题可以抽象成是否能从n个数中选几个出来组成target
 * @Data: Created in 20:25 2022/10/1
 */
public class Num416 {
    // 暴力解超时
    /*static class Solution {
        static boolean flag;
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if(sum%2 == 1)
                return false;
            else {
                flag = false;
                dfs(nums, 0, sum/2);
                return flag;
            }
        }

        public void dfs(int[] nums, int index, int target){
            if(target < 0 || index==nums.length || flag)
                return;
            if(target == 0)
                flag = true;

            if(target >= nums[index])
                dfs(nums, index+1, target-nums[index]);

            dfs(nums, index+1, target);
        }
    }*/

    /*static class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            if(len < 2)
                return false;
            int sum = 0;
            int max = 0;
            for (int num : nums) {
                sum += num;
                max = Math.max(max, num);
            }
            if(sum%2==1 || max>sum/2)
                return false;

            int capacity = sum/2;
            int[][] dp = new int[len][capacity+1];
            for (int i = 0; i < len; i++) {
                dp[i][0] = 1;
            }

            dp[0][nums[0]] = 1;

            for (int i = 1; i < len; i++) {
                for (int j = 1; j <= capacity; j++) {
                    if(j >= nums[i]){
                        if(dp[i-1][j]==1 || dp[i-1][j-nums[i]]==1)
                            dp[i][j] = 1;
                    }
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }

            return dp[len-1][capacity]==1;
        }
    }*/



    // 2022/10/11写
    static class Solution {
        public boolean canPartition(int[] nums) {
            int len = nums.length;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if(sum%2==1)
                return false;

            int bagSize = sum/2;
            int[][] dp = new int[len][bagSize+1];
            for (int j = 0; j <= bagSize; j++) {
                if(j>=nums[0])
                    dp[0][j] = nums[0];
            }
            for (int i = 1; i < len; i++) {
                for (int j = 1; j <= bagSize; j++) {
                    if(j>=nums[i])
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-nums[i]]+nums[i]);
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }

            return dp[len-1][bagSize]==bagSize;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,5};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}
