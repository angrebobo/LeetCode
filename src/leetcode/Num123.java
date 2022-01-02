package leetcode;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/26 17:15
 */

public class Num123 {

    public static int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 1)
            return 0;
        int[] dp = new int[len];
        dp[0] = 0;
        HashMap<Integer, Integer> map = new HashMap();

        for (int i = 1; i < len; i++) {
            if(prices[i] > prices[i-1])
                dp[i] = dp[i-1] +  (prices[i] - prices[i-1]);
            else{
                dp[i] = 0;
                if(dp[i-1] != 0)
                    map.put(map.size()+1, dp[i-1]);
            }
        }
        if(dp[len-1] != 0)
            map.put(map.size()+1, dp[len-1]);

        if(map.size() == 0)
            return 0;
        else if(map.size() == 1)
            return map.get(1);
        else if(map.size() == 2)
            return map.get(1) + map.get(2);
        else{

            int t1 = map.get(1);
            int t2 = 0;
            for (int i = 2; i <= map.size(); i++) {
                if (t1 < map.get(i)) {
                    t2 = t1;
                    t1 = map.get(i);
                }
                else
                    t2 = t2 < map.get(i) ? map.get(i) : t2;
            }
            return t1 + t2;
        }
    }

    public static void main(String[] args) {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(maxProfit(prices));
    }

}
