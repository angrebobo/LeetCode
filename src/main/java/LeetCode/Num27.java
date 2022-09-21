package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:18 2022/9/20
 */
public class Num27 {
    static class Solution {
        public int removeElement(int[] nums, int val) {
            int len = nums.length;
            int left=0, right=len-1;
            while (left <= right) {
                if(nums[left] == val){
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                    right--;
                }
                else
                    left++;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3};
        int val = 3;
        Solution solution = new Solution();
        System.out.println(solution.removeElement(nums, val));
    }
}
