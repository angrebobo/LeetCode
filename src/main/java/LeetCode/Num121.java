package LeetCode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/26 10:50
 */

public class Num121 {


    // 解法1，超时
//    public static int maxProfit(int[] prices) {
//        int max  = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if(prices[i] - prices[j] > max)
//                    max = prices[i] - prices[j];
//            }
//        }
//        return max;
//    }

    // 解法2，动态规划
//    public static int maxProfit(int[] prices){
//        int len = prices.length;
//        //昨天卖出能赚的钱
//        int pre  = 0;
//        int res = 0;
//
//        for (int i = 1; i < len; i++) {
//            //今天和昨天的利润差
//            int diff = prices[i] - prices[i-1];
//            //今天卖出的钱，等于昨天卖出的钱+今天和昨天的利润差
//            pre = Math.max(pre + diff, 0);
//            res = Math.max(res, pre);
//        }
//        return res;
//    }




    //解法4，用栈
//    public static int maxProfit(int[] prices){
//        Stack<Integer> stack = new Stack<>();
//        int len = prices.length;
//        int max = 0;
//
//        for (int i = 0; i < len; i++) {
//            if(stack.size()==0 || prices[i]<stack.peek())
//                stack.push(prices[i]);
//            else if(prices[i] > stack.peek())
//                max = Math.max(max, prices[i]-stack.peek());
//        }
//        return max;
//    }

    /*public static int maxProfit(int[] prices){
        int len = prices.length;
        int minVal = prices[0];
        int res = 0;

        for (int i = 1; i < len; i++) {
            if(prices[i] < minVal)
                minVal = prices[i];
            else if(prices[i]-minVal > res)
                res = prices[i] - minVal;
        }
        return res;
    }*/

    /**
     * @Description 2021.09.21写
     * @param
     * @return
     */
    static class Solution {
        /*public int maxProfit(int[] prices) {
            int min = prices[0];
            int res = 0;
            int len = prices.length;

            for (int i = 1; i < len; i++) {
                if(prices[i] < min)
                    min = prices[i];
                else if(prices[i]-min > res)
                    res = prices[i]-min;
            }
            return res;
        }*/

        //解法3，动态规划
        public static int maxProfit(int[] prices){
            int len = prices.length;
            // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金
            // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金
            int[][] dp = new int[len][2];

            dp[0][0] = 0;
            dp[0][1] = -prices[0];

            for (int i = 1; i < len; i++) {
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            }
            return dp[len-1][0];
        }
    }


    public static void main(String[] args) {
        int[] price = {7,1,5,3,6,4};
//        System.out.println(maxProfit(price));
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(price));
    }
}
