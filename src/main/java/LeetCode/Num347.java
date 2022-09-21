package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 16:33 2022/9/21
 */
public class Num347 {
    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0)+1);
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            for (Integer key : map.keySet()) {
                if(queue.size()<k){
                    queue.add(new int[]{key, map.get(key)});
                }
                else if(queue.size()==k){
                    if(map.get(key) > queue.peek()[1]){
                        queue.poll();
                        queue.add(new int[]{key, map.get(key)});
                    }
                }
            }

            int[] ans = new int[k];
            for (int i = 0; i < k; i++) {
                ans[i] = queue.poll()[0];
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        int k = 1;
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(nums, k)));
    }
}
