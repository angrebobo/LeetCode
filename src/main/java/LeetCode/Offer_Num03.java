package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:47 2022/8/22
 */
public class Offer_Num03 {
    static class Solution {
        //方法1, hashmap

        //方法2, 原地置换
        public int findRepeatNumber(int[] nums) {
            int len = nums.length;

            int i = 0;
            while (i < len){
                if(i != nums[i]){
                    if(nums[nums[i]] == nums[i])
                        return nums[i];
                    int temp = nums[nums[i]];
                    nums[nums[i]] = nums[i];
                    nums[i] = temp;
                }
                else
                    i++;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 1, 6, 2, 5, 3};
        Solution solution = new Solution();
        System.out.println(solution.findRepeatNumber(nums));
    }
}
