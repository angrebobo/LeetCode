package 面试题.百度.四月十九日;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:21 2022/4/19
 */
public class Num2 {
    static int max = Integer.MIN_VALUE;
    static int pos;
    static int len;
    public static void dfs(int[] money, int index, int collect){
        if(index == pos && money[index] == 0){
            return;
        }

        if(index == pos && collect == 0){

            //拿金币
            if(money[index] >= 2){
                money[index]--;
                collect++;
                dfs(money, index, collect);
                if(index+1 < len && money[index+1]>0)
                    dfs(money, index+1, collect);
                if(index-1 >= 0 && money[index-1]>0)
                    dfs(money, index-1, collect);
            }

            //不拿金币
            if(index+1 < len && money[index+1]>0)
                dfs(money, index+1, collect);
            if(index-1 >= 0 && money[index-1]>0)
                dfs(money, index-1, collect);
        }
        else {
            money[index]--;
            collect++;
            if(index == pos){
                max = Math.max(max, collect);
            }

            if(money[index] != 0)
                dfs(money, index, collect);
            if(index+1 < len && money[index+1]>0)
                dfs(money, index+1, collect);
            if(index-1 >= 0 && money[index-1]>0)
                dfs(money, index-1, collect);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = in.nextInt();
        }
        pos = K-1;
        len = N;
        dfs(money, K-1, 0);
        System.out.println(max);
    }
}
