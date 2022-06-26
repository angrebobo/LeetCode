package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解：https://leetcode.cn/problems/maximum-product-subarray/solution/hua-jie-suan-fa-152-cheng-ji-zui-da-zi-xu-lie-by-g/
 * @Data: Created in 16:24 2022/6/26
 */
public class Num152 {
    static class Solution {
        public int maxProduct(int[] nums) {
            // imax表示以当前点结尾的连续子数组的最大值，imin表示以当前点结尾的连续子数组的最小值
            int imax = nums[0], imin =nums[0];
            int res = imax;
            for (int i = 1; i < nums.length; i++) {
                if(nums[i] >= 0){
                    imax = Math.max(nums[i], nums[i]*imax);
                    imin = Math.min(nums[i], nums[i]*imin);
                }
                else {
                    int temp = imax;
                    imax = Math.max(nums[i], nums[i]*imin);
                    imin = Math.min(nums[i], nums[i]*temp);
                }

                res = Math.max(res, imax);
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,3,-4};
        Solution solution = new Solution();
        System.out.println(solution.maxProduct(nums));
    }
}
