package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解： https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * 这一题看题解理解
 * @Data: Created in 17:09 2021/5/28
 */
public class Num31 {
    static class Solution {
        /*public void nextPermutation(int[] nums) {
            int len = nums.length;
            if(len == 1)
                System.out.println(nums[0]);

            int i = 0,j = 0;
            for (int k = len-1; k >= 1; k--) {
                if(nums[k-1] < nums[k]){
                    i = k-1;
                    j = k;
                    break;
                }
            }

            //i，j无变化说明整个数组是有序的
            if(i == 0 && j == 0){
                for (int k = 0; k < len/2; k++) {
                    int temp = nums[len-1-k];
                    nums[len-1-k] = nums[k];
                    nums[k] = temp;
                }
                for (int k = 0; k < len; k++) {
                    System.out.print(nums[k]);
                }
            }
            //nums存在更大的字典序
            else {
                int m = 0;
                for (int k = len-1; k >= j; k--) {
                    if(nums[k] > nums[i]){
                        m = k;
                        break;
                    }
                }

                int temp = nums[m];
                nums[m] = nums[i];
                nums[i] = temp;

                Arrays.sort(nums, i + 1, len);
                for (int k = 0; k < len; k++) {
                    System.out.print(nums[k]);
                }
            }
        }*/

        // 2022.09.08写
        public static void nextPermutation(int[] nums) {
            int len = nums.length;
            if(len==1) return;

            int j = len-1;
            // 找到第一对相邻升序
            while (j>=1 && nums[j-1] >= nums[j])
                j--;
            // j==0表示整个数组都是逆序的，比如321，那就将整个数组排序
            if(j == 0){
                for (int i = 0; i < len/2; i++) {
                    int temp = nums[i];
                    nums[i] = nums[len-1-i];
                    nums[len-1-i] = temp;
                }
            }
            else {
                int i = j-1;
                j = len-1;
                // 从后向前，找到一个大于nums[i]的数，并交换
                while (j > i && nums[j]<=nums[i])
                    j--;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                // 将i+1~len-1区域，从小到大排序
                Arrays.sort(nums, i+1, len);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
    }
}
