package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/majority-element/
 * @Data: Created in 0:05 2021/12/28
 */
public class Num169 {

    static class Solution {

        //方法1，哈希表
        /*public int majorityElement(int[] nums) {
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
        }*/

        //排序，下标n/2的位置一定是众数
        /*public int majorityElement(int[] nums){
            Arrays.sort(nums);
            return nums[nums.length/2];
        }*/

        public int majorityElement(int[] nums){
            int candidate = nums[0];
            int count = 1;
            int len = nums.length;

            for (int i = 1; i < len; i++) {
                if(candidate == nums[i]){
                    count++;
                }
                else {
                    if(--count == 0){
                        candidate = nums[i];
                        count = 1;
                    }
                }
            }
            return candidate;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,1,1,1,2,2};

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
