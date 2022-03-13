package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:30 2022/3/13
 */
public class Num6031 {

    static class Solution {
        public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
            Set<Integer> ans = new HashSet<>();
            int len = nums.length;

            for (int i = 0; i < len; i++) {
                if(nums[i] == key){
                    for (int j = k; j > 0; j--) {
                        if(i - j >= 0)
                            ans.add(i-j);
                    }
                    ans.add(i);
                    for (int j = 1; j <= k; j++) {
                        if(i+j < len)
                            ans.add(i+j);
                    }
                }
            }

            List<Integer> list = new LinkedList<>();
            list.addAll(ans);
            Collections.sort(list);
            return list;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,9,1,3,9,5};
        int key = 9;
        int k = 1;

        Solution solution = new Solution();
        List<Integer> list = solution.findKDistantIndices(nums, key, k);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
