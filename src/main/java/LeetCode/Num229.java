package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:48 2022/5/28
 */
public class Num229 {

    static class Solution {
        public List<Integer> majorityElement(int[] nums) {
            int len = nums.length;
            int count = len/3;
            HashMap<Integer, Integer> map = new HashMap<>();
            List<Integer> res = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                if(map.containsKey(nums[i])){
                    map.put(nums[i], map.get(nums[i])+1);
                }
                else {
                    map.put(nums[i], 1);
                }
            }

            for (Integer key : map.keySet()){
                if(map.get(key) > count)
                    res.add(key);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums).toString());
    }
}
