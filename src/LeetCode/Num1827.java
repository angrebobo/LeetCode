package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 16:01 2022/4/19
 */
public class Num1827 {
    static class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            int len = nums.length;
            if(len == 0 || len == 1)
                return 0;

            for (int i = 1; i < len; i++) {
                if(nums[i] > nums[i-1])
                    continue;
                else {
                    ans += nums[i-1] + 1 - nums[i];
                    nums[i] = nums[i-1] + 1;
                }
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,5,2,4,1};
        Solution solution = new Solution();
        System.out.println(solution.minOperations(nums));
    }
}
