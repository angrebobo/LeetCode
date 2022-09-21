import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:51 2022/9/21
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }
        int[] radius = new int[n];
        for (int i = 0; i < n; i++) {
            radius[i] = sc.nextInt();
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        int[][] intervals = new int[n][3];
        for (int i = 0; i < n; i++) {
            intervals[i][0] = position[i]-radius[i];
            intervals[i][1] = position[i]+radius[i];
            intervals[i][2] = values[i];
        }
        int bagSize = intervals[n-1][1]+1;
        int[] dp = new int[bagSize+1];
        for (int i = 0; i < n; i++) {
            int value = intervals[i][2];
            int left = intervals[i][0], right=intervals[i][1];
            for (int j = bagSize; j >= right; j--) {
                dp[j] = Math.max(dp[j], dp[j-right+left-1]+value);
            }
        }
        System.out.println(dp[bagSize]);
    }
}
