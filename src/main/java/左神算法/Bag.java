package 左神算法;

/**
 * @author: HuangSiBo
 * @Description: 01背包
 * 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
 * @Data: Created in 21:08 2022/5/5
 */
public class Bag {

    //用暴力递归的方法做。每个物品都有两种状态，装或者不装。该方法的时间复杂度是O(2*n)
    /*static int maxValue = 0;
    static int capacity;
    public static void findMaxValue(int[] weights, int[] values, int capacity, int index, int value){
        if(capacity < 0)
            return;
        if(index >= weights.length)
            return;
        maxValue = Math.max(maxValue, value);

        //不装物品
        findMaxValue(weights, values, capacity, index+1, value);

        //装物品
        findMaxValue(weights, values, capacity-weights[index], index+1, value+values[index]);
    }*/

    //用动态规划做
    public static int findMaxValue(int[] weights, int[] values, int capacity){
        int len = weights.length;
        //dp[i][j]的含义是从0-i的物品里任意取，装进容量为j的背包里，产生的最大的价格总和
        int[][] dp = new int[len][capacity+1];
        for (int j = weights[0]; j <= capacity; j++) {
            dp[0][j] = values[0];
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= capacity; j++) {
                if(j >= weights[i])
                    //第i件物品，就两种状态，放或者不放
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weights[i]]+values[i]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[len-1][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 3, 4};
        int[] values = new int[]{15, 20, 30};

        //暴力递归
        /*capacity = 4;
        findMaxValue(weights, values, capacity, 0, 0);
        System.out.println(maxValue);*/

        int capacity = 4;
        System.out.println(findMaxValue(weights, values, capacity));
    }
}
