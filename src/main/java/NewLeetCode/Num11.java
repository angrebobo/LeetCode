package NewLeetCode;

/**
 * 乘最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Num11 {

    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int res = 0;

        while (left < right){
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            // 面积由较短的边决定，所以要移动较短的边
            if(height[left] < height[right]){
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(new Num11().maxArea(height));
    }
}
