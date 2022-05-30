package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:14 2022/5/30
 */
public class Offer_Num39 {

    //摩尔投票法，时间复杂度O(n),空间复杂度O(1)
    static class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0];
            int count = 1;

            for (int i = 1; i < nums.length; i++) {
                if(nums[i] == candidate)
                    count++;
                else {
                    if(--count == 0){
                        candidate = nums[i];
                        count = 1;
                    }
                }
            }

            return candidate;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
