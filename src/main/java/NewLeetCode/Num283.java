package NewLeetCode;

import java.util.Arrays;

/**
 * 移动零
 * https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Num283 {

    /**
     * 暴力解法
     * 将非零元素替换到前面
     */
    public static void moveZeroes(int[] nums) {
        int length = nums.length;
        int left = 0, right;
        for (; left < length; left++) {
            if(nums[left] == 0){
                break;
            }
        }

        for (right = left+1; right < length; right++) {
            if(nums[right] != 0){
                nums[left] = nums[right];
                nums[right] = 0;
                left++;
            }
        }
    }

    /**
     * 双指针
     * 将非零元素都移动到前面，剩余的元素都置零
     */
    public static void moveZeroes1(int[] nums) {
        int length = nums.length;
        int left = 0, right=0;
        for (; right < length; right++) {
            if(nums[right] != 0){
                nums[left++] = nums[right];
            }
        }

        for (;left<length;left++){
            nums[left] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12,0,0,0,6,6,546,3,54,89,0,0,6,0};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
