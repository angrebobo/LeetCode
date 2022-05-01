package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/container-with-most-water/
 * @Data: Created in 10:10 2022/3/10
 */
public class Num11 {
    static class Solution {
        public int maxArea(int[] height) {
            int left = 0;
            int right = height.length-1;
            int res= 0;

            while (left < right){
                if(height[left] < height[right]){
                    res = Math.max(res, (right-left)*height[left]);
                    left++;
                }
                else {
                    res = Math.max(res, (right-left)*height[right]);
                    right--;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,1};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(height));
    }
}
