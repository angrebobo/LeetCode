package LeetCode;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/10 23:33
 **/
public class Num55 {

    static class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            if(n == 0) return true;
            int k = 0;
//            for (int i = 0; i < n-1; i++) {
//                if(k >= i){
//                    k = Math.max(k, i+nums[i]);
//                    if(k >= n-1)
//                        return true;
//                }
//            }
//            return false;

            for (int i = 0; i < n; i++) {
                if(k < i) return false;
                k = Math.max(k, i+nums[i]);
            }
            return true;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,2,3};
        Solution solution = new Solution();
        System.out.println(solution.canJump(nums));
    }
}
