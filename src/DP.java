/**
 * @author: HuangSiBo
 * @Description: DP类算法
 * @Data: Created in 23:44 2021/9/25
 */
public class DP {

    /**
     * @Description 数塔问题
     * @param
     * @return
     */
    public static int DP1(){
        int[][] nums = new int[][]{{5},
                                   {8, 3},
                                   {12,7, 16},
                                   {4, 10,11,6},
                                   {9, 5, 3, 9,4}};
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < nums[len-1].length; i++) {
            dp[len-1][i] = nums[len-1][i];
        }

        for (int i = len-2; i >= 0 ; i--) {
            int size = nums[i].length;
            for (int j = 0; j < size; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + nums[i][j];
            }
        }

        return dp[0][0];
    }

    /**
     * @Description 最大连续子序列和
     * @param
     * @return
     */
    public static int DP2(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * @Description 最长不下降子序列
     * @param
     * @return
     */
    public static int DP3(int[] nums){
        int len = nums.length;
        int[] dp = new int[len];

        int max = 1;

        for (int i = 0; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i] >= nums[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    /**
     * @Description 最长公共子序列
     * @param
     * @return
     */
    public static void DP4(){

    }


    public static void main(String[] args) {
//        System.out.println(DP1());

//        int[] nums = new int[]{-2, 11, -4, 13, -5, -2};
//        System.out.println(DP2(nums));

        int[] nums = new int[]{1, 2, 4, -1, 5, 0};
        System.out.println(DP3(nums));
    }
}
