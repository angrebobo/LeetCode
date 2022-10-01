/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:54 2022/9/17
 */
public class Test {
    public static int findMaxValue(int[] weights, int[] values, int capacity){
        int len = weights.length;
        // dp[i][j]表示物品0-i放在容量为j的背包里的最大价值
        int[][] dp = new int[len][capacity+1];
        for (int i = weights[0]; i <= capacity; i++) {
            dp[0][i] = values[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= capacity; j++) {
                // 当前背包放得下物品i
                if(j >= weights[i]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[len-1][capacity];
    }

    public static void main(String[] args) {

    }
}
