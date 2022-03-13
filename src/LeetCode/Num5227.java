package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/maximize-the-topmost-element-after-k-moves/
 * @Data: Created in 10:52 2022/3/13
 */
public class Num5227 {

    //如果nums.length = 1，那么如果 k 是偶数，那么栈里存在nums[0]；如果 k 是奇数，那么栈里一定没有任何元素，返回 -1。
    //否则，栈顶元素可以是：
    //nums 的前 k-1 个数的最大值；
    //nums 的第 k + 1 个数（如果有，此时出栈前 k 个数即可）；
    //注意，nums 的第 k 个数永远不会出现在栈顶。
    static class Solution {
        public int maximumTop(int[] nums, int k) {
            int len = nums.length;

            if(len == 1){
                return k%2==0 ? nums[0] : -1;
            }

            int max = Integer.MIN_VALUE;
            for (int i = 0; i<len && i<k-1; i++) {
                max = Math.max(max, nums[i]);
            }
            if(k < len){
                max = Math.max(max, nums[k]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{18};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.maximumTop(nums, k));
    }
}
