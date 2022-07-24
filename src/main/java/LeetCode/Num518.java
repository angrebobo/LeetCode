package LeetCode;

public class Num518 {
    static class Solution {

        // 暴力解，超时
        /*public int change(int amount, int[] coins) {
            Set<HashMap<Integer, Integer>> set = new HashSet<>();
            HashMap<Integer, Integer> map = new HashMap<>();
            dfs(amount, coins, 0, set, map);
            return set.size();
        }


        public void dfs(int amount, int[] coins, int cur, Set<HashMap<Integer, Integer>> set, HashMap<Integer, Integer> map){
            if(cur > amount)
                return;
            if(cur == amount){
                set.add( new HashMap<>(map) );
                return;
            }

            for(Integer coin : coins){
                map.put(coin, map.getOrDefault(coin, 0)+1);
                dfs(amount, coins, cur+coin, set, map);
                if(map.get(coin)-1 == 0)
                    map.remove(coin);
                else
                    map.put(coin, map.get(coin)-1);
            }
        }*/

        /*public int change(int amount, int[] coins) {
            int[][] map = new int[coins.length][amount+1];
            return dfs(amount, coins, 0, 0, map);
        }


        public int dfs(int amount, int[] coins, int cur, int index, int[][] map){
            if(cur > amount || index >= coins.length)
                return 0;
            if(cur == amount)
                return 1;

            if(map[index][cur] != 0)
                return map[index][cur];
            int res = 0;

            //不选
            res += dfs(amount, coins, cur, index+1, map);

            //
            res += dfs(amount, coins, cur+coins[index], index, map);

            map[index][cur] = res;
            return res;
        }*/

        public int change(int amount, int[] coins) {
            int[][] dp = new int[coins.length+1][amount+1];
            dp[0][0] = 1;
            for (int j = 1; j < amount+1; j++) {
                dp[0][j] = 0;
            }

            for (int i = 1; i < coins.length+1; i++) {
                int val = coins[i-1];
                for (int j = 0; j < amount+1; j++) {
                    dp[i][j] = dp[i-1][j];

                    for (int k = 1; j-k*val >= 0; k++) {
                        dp[i][j] += dp[i-1][j-k*val];
                    }
                }
            }

            return dp[coins.length][amount];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.change(5, new int[]{1, 2, 5}));
    }
}
