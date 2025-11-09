package NewLeetCode;

/**
 * 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/description/
 * 题解：https://leetcode.cn/problems/maximum-subarray/solutions/8975/hua-jie-suan-fa-53-zui-da-zi-xu-he-by-guanpengchn
 */
public class Num53 {

    public int maxSubArray(int[] nums) {
        // 这个答案超内存限制了
//        int maxNum = nums[0];
//        int len = nums.length;
//        int[][] dp = new int[len][len];
//        dp[0][0] = nums[0];
//        for (int j = 0; j < len; j++) {
//            for (int i = 0; i <= j; i++) {
//                if(j==0){
//                    continue;
//                }
//                dp[i][j] = dp[i][j-1] + nums[j];
//                maxNum = Math.max(dp[i][j], maxNum);
//            }
//        }
//        return maxNum;

        // 用一维动态规划
        int sum = 0;
        int ans = nums[0];
        // 遍历该数字时，sum是上一位的最大连续子数组和
        for (int num : nums) {
            if(sum > 0 ){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        System.out.println(new Num53().maxSubArray(nums));
    }
}
