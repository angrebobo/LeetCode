package 笔试题.拼多多;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:54 2022/9/25
 */
public class Main1 {
    public static int count(int k, int[] nums){
        int len = nums.length;
        int[] dp = new int[len];
        if(nums[0]>k)
            return 0;
        else {
            int[] preSum = new int[len];
            preSum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                preSum[i] = nums[i]+preSum[i-1];
            }


            for (int i = 0; i < len; i++) {
                if(preSum[i]<=k)
                    dp[i] = (dp[i]+1)%1000000007;
                for (int j = i-1; j >=0 ; j--) {
                    if(preSum[i]-preSum[j]<=k){
                        dp[i] = (dp[i]+dp[j])%1000000007;
                    }
                }
            }
            return dp[len-1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int[] nums = new int[m];
            int max = 0;
            for (int j = 0; j < m; j++) {
                nums[j] = sc.nextInt();
                max = Math.max(max, nums[j]);
            }
            if(max>p)
                System.out.println(0);
            else
                System.out.println( count(k,nums) );
        }
    }
}
