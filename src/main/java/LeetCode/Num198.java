package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:12 2022/6/29
 */
public class Num198 {
    static class Solution {

        // 方法1，暴力解
        /*static int res;
        public int rob(int[] nums) {
            res = 0;
            boolean[] visit = new boolean[nums.length];
            dfs(nums, visit, 0,0);
            return res;
        }

        public void dfs(int[] nums, boolean[] visit, int index,int money){
            if(index == nums.length){
                res = Math.max(res, money);
                return;
            }


            if(index == 0 || (index > 0 && !visit[index-1])){
                dfs(nums, visit, index+1,money);

                visit[index] = true;
                dfs(nums, visit,index+1, money+nums[index]);
                visit[index] = false;
            }
            else
                dfs(nums, visit, index+1,money);
        }*/

        // 方法2，动态规划
        public int rob(int[] nums){
            int len = nums.length;
            if(len == 0) return 0;
            if(len == 1) return nums[0];
            // dp[i]表示从前i间房能偷到最多的钱
            int[] dp = new int[len];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
            }

            return dp[len-1];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        Solution solution = new Solution();
        System.out.println( solution.rob(nums) );
    }
}
