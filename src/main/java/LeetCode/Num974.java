package LeetCode;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:58 2022/4/18
 */
public class Num974 {
    static class Solution {
        public int subarraysDivByK(int[] nums, int k) {
            int len = nums.length;
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0;
            for (int i = 0; i < len; i++) {
                preSum += nums[i];
                int modules = (preSum%k+k) % k;
                count += map.getOrDefault(modules, 0);
                map.put(modules, map.getOrDefault(modules, 0) + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,0,-2,-3,1};
        int K = 5;
        Solution solution = new Solution();
        System.out.println(solution.subarraysDivByK(nums, K));
    }
}
