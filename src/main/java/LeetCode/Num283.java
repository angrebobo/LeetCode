package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:45 2022/7/8
 */
public class Num283 {
    static class Solution {
        //方法1，冒泡思想，效果不好,时间复杂度为O(n^2)
        /*public void moveZeroes(int[] nums) {
            for (int i = nums.length-1; i >= 0; i--) {
                if(nums[i] == 0){
                    for (int j = i; j+1 < nums.length; j++) {
                        if(nums[j+1] != 0)
                            swap(nums, j, j+1);
                    }
                }
            }
        }

        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }*/

        // 方法2，双指针,时间复杂度为O(n)
        /*public void moveZeroes(int[] nums){
            int i=0, j =0;
            for(;i < nums.length; i++){
                if(nums[i] != 0){
                    nums[j++] = nums[i];
                }
            }

            for(; j < nums.length; j++)
                nums[j] = 0;
        }*/

        public void moveZeroes(int[] nums) {
            if(nums==null) {
                return;
            }
            // 两个指针i和j
            int j = 0;
            for(int i=0; i < nums.length; i++) {
                if(nums[i] != 0) {
                    // 当i==j时，置换会出错
                    if(i > j){
                        nums[j] = nums[i];
                        nums[i] = 0;
                    }
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,0,3,1};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
