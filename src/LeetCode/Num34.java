package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @Data: Created in 15:50 2022/3/4
 */
public class Num34 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int index = binarySearch(nums, target);
            if(index == -1)
                return new int[]{-1,-1};
            else {
                int left = index;
                int right = index;
                while (left-1>=0 && nums[left-1]==nums[left])
                    left--;
                while (right+1<=nums.length-1 && nums[right]==nums[right+1])
                    right++;
                return new int[]{left, right};
            }
        }

        //二分查找
        public int binarySearch(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;

            while (low <= high){
                int middle = low + (high-low)/2;
                if(nums[middle] == target)
                    return middle;
                if(nums[middle] > target)
                    high = middle-1;
                else
                    low = middle+1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3};
        int target = 3;

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(nums, target)));
    }
}
