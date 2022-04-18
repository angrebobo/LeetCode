package LeetCode;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:13 2022/4/18
 */
public class Num560 {
    static class Solution {
        //版本1，暴力解，时间复杂度0(n^2)
        /*public int subarraySum(int[] nums, int k) {
            int count = 0;
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                int sum = 0;
                for (int j = i; j < len; j++) {
                    sum += nums[j];
                    if(sum == k) count++;
                }
            }

            return count;
        }*/

        //版本2，前缀和
        /*public int subarraySum(int[] nums, int k){
            int len = nums.length;
            int[] preSum = new int[len];
            preSum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                preSum[i] = nums[i] + preSum[i-1];
            }

            int count = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if(i == 0){
                        if(preSum[j] == k)
                            count++;
                    }
                    else {
                        if(preSum[j] - preSum[i-1] == k)
                            count++;
                    }
                }
            }

            return count;
        }*/

        public int subarraySum(int[] nums, int k){
            int len = nums.length;
            int count = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int preSum = 0;
            for (int i = 0; i < len; i++) {
                preSum += nums[i];

                count += map.getOrDefault(preSum-k, 0);
                map.put(preSum, map.getOrDefault(preSum, 0) + 1);

            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int K = 0;
        Solution solution = new Solution();
        System.out.println(solution.subarraySum(nums, K));
    }
}
