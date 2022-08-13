package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:26 2022/8/13
 */
public class Num977 {
    static class Solution {
        // 方法1，暴力
        /*public int[] sortedSquares(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                int temp = nums[i];
                nums[i] = temp*temp;
            }
            Arrays.sort(nums);
            return nums;
        }*/

        // 方法2,找到分界点。
        // 分界点左侧是负数，右侧是正数，并且两侧都是有序的
        // 用双指针归并
        public int[] sortedSquares(int[] nums){
            return new int[]{};
        }
    }

    public static void main(String[] args) {

    }
}
