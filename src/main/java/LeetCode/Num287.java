package LeetCode;

public class Num287 {

    static class Solution {
        public int findDuplicate(int[] nums) {
            int len = nums.length;

            int left = 1;
            int right = len-1;
            while (left < right){
                int mid = (left + right)/2;

                int count = 0;
                for(int i : nums){
                    if(i <= mid)
                        count++;
                }

                if(count > mid)
                    right = mid;
                else
                    left = mid+1;
            }
            return left;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2,2};
        Solution solution = new Solution();
        System.out.println(solution.findDuplicate(nums));
    }
}
