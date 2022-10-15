package LeetCode;


import java.util.*;

/**
 * @Description TODO
 * @Author HuangSiBo
 * @Date 2022/2/13 15:33
 * 题解：https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 **/
public class Num322 {

    /*public static class Solution {
        public int coinChange(int[] coins, int amount) {
            int len = coins.length;
            int[] dp = new int[amount+1];
            Arrays.fill(dp, amount+1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < len; j++) {
                    if(coins[j] <= i){
                        dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
                    }
                }
            }

            return dp[amount] != (amount+1) ? dp[amount] : -1;
        }
    }*/

    static class Solution {
        public int coinChange(int[] coins, int amount) {
            Arrays.sort(coins);
            List<List<Integer>> ans = new ArrayList<>();
            Deque<Integer> path = new LinkedList<>();
            dfs(coins, amount, 0, path, ans);
            if(ans.size() == 0)
                return -1;

            int min = Integer.MAX_VALUE;
            for (List<Integer> list : ans) {
                min = Math.min(min, list.size());
            }
            return min;
        }

        public void dfs(int[] coins, int amount, int index,
                        Deque<Integer> path, List<List<Integer>> ans){

            if(amount == 0){
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < coins.length; i++) {
                if(amount-coins[i] < 0)
                    break;

                path.addLast(coins[i]);
                dfs(coins, amount-coins[i], i, path, ans);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int[] conis = new int[]{1, 2, 5};
        int amount = 11;
        Solution solution = new Solution();
        System.out.println(solution.coinChange(conis, amount));
    }
}
