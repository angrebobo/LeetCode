package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 12:24 2022/6/29
 */
public class Num179 {
    static class Solution {
        public String largestNumber(int[] nums) {
            String[] ss = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                ss[i] = nums[i] + "";
            }
            Arrays.sort(ss, (a,b)->{
                String temp1 = a+b;
                String temp2 = b+a;
                return temp2.compareTo(temp1);
            });

            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < ss.length; i++) {
                builder.append(ss[i]);
            }
            int len = builder.length();
            int k =0;
            while (k<len-1 && builder.charAt(k)=='0') k++;

            return builder.substring(k);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 00};
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(nums));
    }
}
