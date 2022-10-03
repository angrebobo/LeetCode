package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * https://leetcode.cn/problems/target-sum/solution/mu-biao-he-by-leetcode-solution-o0cp/
 * @Data: Created in 19:54 2022/10/3
 */
public class Num494 {
    static class Solution {
        // 选一堆数取+号，和为A
        // 选一堆数取-号，和为B
        // A+B=sum
        // A-B=target
        // 2*B=
        // B=(sum-target)/2
        // 问题抽象成从nums中选几个数组成的和等于B的方案数
        public int findTargetSumWays(int[] nums, int target) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if(target > sum)
                return 0;

            if((sum-target)%2==1)
                return 0;

            int B = (sum-target)/2;
            int len = nums.length;
            int bagSize = B;
            // dp[i][j]的含义是从数组 nums 的第 0~i 个数中选取元素，使得这些元素之和等于 j 的方案数
            int[][] dp = new int[len][bagSize+1];
            for (int j = 0; j <= bagSize; j++) {
                // 这么写是因为有nums[0]==0这种特殊情况，当背包大小为0是，放或者不放都行，所以方案数为2
                if(j == 0 && j==nums[0])
                    dp[0][j] = 2;
                else if(j == 0 || j==nums[0])
                    dp[0][j] = 1;
                else
                    dp[0][j] = 0;
            }

            for (int i = 1; i < len; i++) {
                for (int j = 0; j <= bagSize; j++) {
                    if(j >= nums[i]){
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i]];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
            }

            return dp[len-1][bagSize];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};
        int target = 3;
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, target));
    }
}
