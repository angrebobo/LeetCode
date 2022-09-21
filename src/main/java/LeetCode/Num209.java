package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:57 2022/9/21
 */
public class Num209 {
    static class Solution {
        public int minSubArrayLen(int target, int[] nums) {
            int left=0,right;
            int cur = 0;
            int len = nums.length;
            int minLen = Integer.MAX_VALUE;

            for (right = 0; right < len; right++) {
                cur += nums[right];
                while (left<right && cur-nums[left]>=target){
                    cur -= nums[left];
                    left++;
                }
                if(cur>=target)
                    minLen = Math.min(minLen, right-left+1);
            }

            return minLen==Integer.MAX_VALUE ? 0 : minLen;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        int target = 7;
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
