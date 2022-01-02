package leetcode;

import java.util.HashMap;

public class Num1 {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            HashMap<Integer, Integer> map = new HashMap<>();
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                if(map.containsKey(target - nums[i])){
                    ans[0] = i;
                    ans[1] = map.get(target - nums[i]);
                    break;
                }
                else map.put(nums[i], i);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3,2,4};
        int target = 6;
        int[] ans = solution.twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}
