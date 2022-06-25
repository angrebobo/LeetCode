package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:13 2022/6/25
 */
public class Num128 {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }
            int maxLen = 0;

            for (int i = 0; i < nums.length; i++) {
                int cur = nums[i];
                int len = 1;

                if(!set.contains(cur-1)){
                    while (set.contains(cur+1)){
                        cur += 1;
                        len += 1;
                    }
                    maxLen = Math.max(len, maxLen);
                }
            }

            return maxLen;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        Solution solution = new Solution();
        System.out.println(solution.longestConsecutive(nums));
    }
}
