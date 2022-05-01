package 笔试题.腾讯.四月二十五;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:39 2022/4/24
 */
public class Num5 {
    static int max = Integer.MIN_VALUE;
    public static void dfs(int[] price, int day, int money, int count){
        if(money < 0)
            return;
        if(count < 0)
            return;
        if(day == price.length-1){
            max = Math.max(max, money+count*price[price.length-1]);
            return;
        }

        //买股票
        dfs(price, day+1, money-price[day], count+1);

        //卖股票
        dfs(price, day+1, money+price[day], count-1);

        dfs(price, day+1, money, count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }
        dfs(price, 0, m, 0);
        System.out.println(max);
    }
}
