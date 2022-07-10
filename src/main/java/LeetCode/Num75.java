package LeetCode;

import java.util.Arrays;

public class Num75 {
    static class Solution {
        public void sortColors(int[] nums) {
            Arrays.sort(nums);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,0,2,1,1,0};
        Solution solution = new Solution();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
