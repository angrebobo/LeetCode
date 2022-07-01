package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:23 2022/7/1
 */
public class Num290 {
    static class Solution {
        // 方法1，暴力解，两层for循环，时间复杂度O(n^2)
        /*public int minSubArrayLen(int target, int[] nums) {

        }*/

        // 方法2，滑动窗口
        /*public int minSubArrayLen(int target, int[] nums) {
            int len = nums.length;
            if(len == 0) return 0;
            int start = 0, end = 0;
            int res = Integer.MAX_VALUE;
            int sum = 0;
            while (end < len){
                sum += nums[end];
                while (sum >= target){
                    res = Math.min(res, end-start+1);
                    sum -= nums[start];
                    start++;
                }
                end++;
            }
            return res == Integer.MAX_VALUE ? 0 : res;
        }*/

        // 方法3，前缀和+二分查找，时间复杂度O(n * logN)
        public int minSubArrayLen(int target, int[] nums){
            int len = nums.length;
            if(len == 0) return 0;
            int ans = Integer.MAX_VALUE;
            int[] sum = new int[len+1];
            for (int i = 1; i < len+1; i++) {
                sum[i] = nums[i-1] + sum[i-1];
            }

            for (int i = 0; i < len+1; i++) {
                int temp = sum[i] + target;
                int bound = Arrays.binarySearch(sum, temp);
                if(bound < 0)
                    bound = -bound - 1;
                if(bound < len+1)
                    ans = Math.min(ans, bound-i);
            }

            return ans==Integer.MAX_VALUE ? 0 : ans;
        }
    }

    public static void main(String[] args) {
        int target = 7;
        int[] nums = new int[]{2,3,1,2,4,3};
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
