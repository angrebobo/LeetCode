package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:18 2022/7/16
 */
public class Offer_Num21 {
    static class Solution {
        public int[] exchange(int[] nums) {
            int left = 0;
            int right = nums.length-1;
            while (left < right){
                while (left<right && nums[left]%2==1)
                    left++;
                while (left<right && nums[right]%2==0)
                    right--;

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        Solution solution = new Solution();
        solution.exchange(nums);
        System.out.println(Arrays.toString(nums));
    }
}
