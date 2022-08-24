package LeetCode;

import java.util.Arrays;

/**
 * 题解：https://leetcode.cn/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode-solution-nipk/
 *
 *
 * 思路：
 * nums = "----->-->"; k =3
 * result = "-->----->";
 *
 * reverse "----->-->" we can get "<--<-----"
 * reverse "<--" we can get "--><-----"
 * reverse "<-----" we can get "-->----->"
 * this visualization help me figure it out :)
 *
 * 就是把数组拆分成两部分，前k个一组，后len-k个一组
 */
public class Num189 {

    static class Solution {
        public void rotate(int[] nums, int k) {
            int len = nums.length;
            k = (k>len) ? (k%len) : k;
            reverse(nums, 0, len-1);
            reverse(nums, 0, k-1);
            reverse(nums, k, len-1);
        }

        public void reverse(int[] nums, int beg, int end){
            if(beg < end){
                int mid = beg + (end-beg)/2;
                for (int i = beg; i <= mid; i++) {
                    int temp = nums[i];
                    nums[i] = nums[end-(i-beg)];
                    nums[end-(i-beg)] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums = new int[]{-1};
        Solution solution = new Solution();
        solution.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
