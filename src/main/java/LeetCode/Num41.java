package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:02 2022/6/27
 */
public class Num41 {
    static class Solution {
        // 方法1，不满足常数额外空间复杂度的要求
        /*public int firstMissingPositive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                set.add(nums[i]);
            }

            for (int i = 1;; i++) {
                if(!set.contains(i))
                    return i;
            }
        }*/

        // 方法2，原地哈希，https://leetcode.cn/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
        public int firstMissingPositive(int[] nums){
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                // 这里用while而不用if的原因：如果nums[i]，大于0且小于len，并且这个数不在它该在的位置
                // ，一定要保证它去到正确的位置
                // 如果用if，那只能置换一次，并且置换后，nums[i]依旧有可能不在正确的位置
                while (nums[i]>0 && nums[i]<len && nums[nums[i]-1] != nums[i]){
                    swap(nums, i, nums[i]-1);
                }
            }

            for (int i = 0; i < len; i++) {
                if(nums[i] != i+1)
                    return i+1;
            }

            return len+1;
        }

        public void swap(int[] nums, int a, int b){
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,4,2,1,9,10};
        Solution solution = new Solution();
        System.out.println( solution.firstMissingPositive(nums) );
    }
}
