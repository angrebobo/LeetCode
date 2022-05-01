package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/find-peak-element/
 * 只需返回任意一个峰值
 * @Data: Created in 15:43 2022/3/6
 */
public class Num162 {
    static class Solution {
        public int findPeakElement(int[] nums) {
            int left = 0;
            int right = nums.length-1;

            while (left < right){
                int mid = left + (right-left)/2;
                if(nums[mid] > nums[mid+1])
                    right = mid;
                else
                    left = mid+1;
            }
            return right;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution.findPeakElement(nums));
    }
}
