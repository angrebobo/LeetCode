package LeetCode;

public class Num674 {

    static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            int len = nums.length;
            int max = 0;
            for (int i = 0; i < len; i++) {
                int j = i;
                for (; j < len-1; j++) {
                    if(nums[j] >= nums[j+1])
                        break;
                }
                max = Math.max(max, j-i+1);
            }
            return max;
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,2,2,2};
        Solution solution = new Solution();
        System.out.println(solution.findLengthOfLCIS(nums));
    }
}
