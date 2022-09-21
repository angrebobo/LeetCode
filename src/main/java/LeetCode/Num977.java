package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:26 2022/8/13
 */
public class Num977 {
    static class Solution {
        // 方法1，暴力
        /*public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = temp*temp;
            }
            Arrays.sort(nums);
            return nums;
        }*/


        public int[] sortedSquares(int[] nums){
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                nums[i] = nums[i]*nums[i];
            }

            for (int i = len-1; i >= 1; i--) {
                for (int j = 0; j < i; j++) {
                    if(nums[j] > nums[j+1]){
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }
            }

            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,-423,1,-23};

        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortedSquares(nums)));
    }
}
