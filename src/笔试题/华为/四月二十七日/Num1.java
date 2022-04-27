package 笔试题.华为.四月二十七日;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:01 2022/4/27
 */
public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] record = new int[m][3];
        int[] price = new int[n+1];
        Arrays.fill(price, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            record[i][0] = sc.nextInt();
            record[i][1] = sc.nextInt();
            record[i][2] = sc.nextInt();
            for (int j = record[i][0]; j <= record[i][1]; j++) {
                price[j] = Math.min(price[j], record[i][2]);
            }
        }

        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans+=price[i];
        }
        System.out.println(ans);
    }
}
