package 笔试题.滴滴;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:01 2022/9/4
 */
public class Main2 {

    public static int calculate(int num){
        String s = num+"";
        int ans = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i++) {
            ans ^= s.charAt(i)-'0';
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] left = new int[T+1];
        int[] right = new int[T+1];
        int[] t = new int[T+1];
        for (int i = 1; i <= T; i++) {
            left[i] = sc.nextInt();
        }
        for (int i = 1; i <= T; i++) {
            right[i] = sc.nextInt();
        }
        for (int i = 1; i <= T; i++) {
            t[i] = sc.nextInt();
        }

        for (int i = 1; i <= T; i++) {
            int ans = 0;
            for (int j = left[i]; j <= right[i]; j++) {
                if(calculate(j)==t[i])
                    ans++;
            }
            System.out.print(ans + " ");
        }
    }
}
