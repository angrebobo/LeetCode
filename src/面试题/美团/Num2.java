package 面试题.美团;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 现在有一个序列，序列中仅包含1和-1的两种数字。小美现在想要知道，有多少个连续子序列，序列中的数字乘积为正。n≤5000。
 * @Data: Created in 21:59 2022/4/14
 */
public class Num2 {

    public static int dp( int[] nums){
        int len = nums.length;
        int max = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = nums[i];
            if(dp[i][i] == 1)
                max++;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                dp[i][j] = dp[i][j-1] *  nums[j];
                if(dp[i][j] == 1)
                    max++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.println(dp(nums));
    }
}
