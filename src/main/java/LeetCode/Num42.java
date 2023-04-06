package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解：https://leetcode.cn/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 * @Data: Created in 20:42 2022/6/12
 */
public class Num42 {
    static class Solution {
        //按列法
        //求出左边最高的列leftMax，右边最高的列rightMax，两者中取小的值temp
        //根据木桶效应，如果temp比当前列值大，则能积累雨水，数量为temp-当前列
        //时间复杂度为O(n^2),遍历数组n，每个列求左右最大值n
        /*public int trap(int[] height) {
            int count = 0;
            int len = height.length;
            int leftMax, rightMax;
            for (int i = 1; i < len-1; i++) {
                leftMax = 0;
                rightMax = 0;
                for (int left = 0; left < i; left++) {
                    leftMax = Math.max(leftMax, height[left]);
                }
                for (int right = i+1; right < len; right++) {
                    rightMax = Math.max(rightMax, height[right]);
                }
                int temp = Math.min(leftMax, rightMax);
                if(temp > height[i])
                    count += temp-height[i];
            }

            return count;
        }*/

        //求当前列左右列的最大值，用动态规划
        //时间复杂度O(n)
        /*public int trap(int[] height){
            int count = 0;
            int len = height.length;
            int[] leftMax = new int[len];
            int[] rightMax = new int[len];
            leftMax[0] = 0;
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
            }
            rightMax[len-1] = 0;
            for (int i = len-2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
            }
            for (int i = 1; i < len-1; i++) {
                int temp = Math.min(leftMax[i], rightMax[i]);
                if(temp > height[i])
                    count += temp-height[i];
            }

            return count;
        }*/
    }

    // 2022/10/13写
    public static int trap(int[] height) {
        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        leftMax[0] = 0;
        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i-1]);
        }
        rightMax[len-1] = 0;
        for (int i = len-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i+1]);
        }

        int count = 0;
        for (int i = 0; i < len; i++) {
            int temp = Math.min(leftMax[i], rightMax[i]);
            if(temp > height[i])
                count += temp-height[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] height = new int[]{4,2,0,3,2,5};
        System.out.println(trap(height));
    }
}