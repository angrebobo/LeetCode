package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/majority-element/
 * @Data: Created in 0:05 2021/12/28
 */
public class Num169 {

    static class Solution {
        public int majorityElement(int[] nums) {
            int n = nums.length;
            if(n == 1) return nums[0];
            Map<Integer,Integer> map = new HashMap<>();
            //for循环中一定会return
            for (int i = 0; i < n; i++) {
                if(map.containsKey(nums[i])){
                    if(map.get(nums[i])+1 >= Math.nextUp(n/2))
                        return nums[i];
                    else {
                        map.put(nums[i], map.get(nums[i])+1);
                    }
                }
                else {
                    map.put(nums[i], 1);
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
