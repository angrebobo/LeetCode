package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * @Data: Created in 14:29 2022/3/6
 */
public class Num153 {
    static class Solution {
        public int findMin(int[] nums) {
            int left = 0;
            int right = nums.length-1;

            while (left < right){
                if(nums[left] < nums[right])
                    return nums[left];
                int mid = left + (right-left)/2;
                if(nums[left] == nums[mid]){
                    left ++;
                }
                else if(nums[left] < nums[mid]) left = mid + 1;//递增区间，最小值不会出现在这里
                else right = mid;//无法排除mid
            }
            return nums[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        Solution solution = new Solution();
        System.out.println(solution.findMin(nums));
    }
}
