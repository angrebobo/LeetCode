package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:08 2022/8/13
 */
public class Num35 {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            int left = 0;
            int right = nums.length-1;
            int middle;
            while (left<=right){
                middle = (left+right)/2;
                if(nums[middle]==target)
                    return middle;
                if(nums[middle]<target)
                    left = middle+1;
                else right = middle-1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        int target = 2;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(nums, target));
    }
}
