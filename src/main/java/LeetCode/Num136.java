package LeetCode;

public class Num136 {
    static class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for(int i : nums)
                res ^= i;
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,1,2,1,2};
        Solution solution = new Solution();
        System.out.println(solution.singleNumber(nums));
    }
}
