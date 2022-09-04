package 笔试题.蔚来;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:54 2022/9/3
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] nums = new int[n];
        String[] ss = sc.nextLine().split(" ");
        for(int i=0; i<n; i++){
            nums[i] = Integer.valueOf(ss[i]);
        }
        int[] dp = new int[100050];
        dp[0]=0; dp[1]=0; dp[2]=1; dp[3]=2;
        for(int i=4; i<100001; i++){
            dp[i] = dp[i-1]+1;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0){
                    dp[i] = Math.min(dp[i], dp[j]+dp[i/j]+1);
                }
            }
        }
        int ans = 0;
        for(int i =0; i<n; i++){
            ans += dp[nums[i]];
        }
        System.out.println(ans);
    }
}
