package 笔试题.腾讯.四月二十五;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:09 2022/4/24
 */
public class Num3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();

        int[] attackPreSum = new int[n];
        int[] defendPreSum = new int[n];
        if(s.charAt(0) == '0'){
            attackPreSum[0] = 1;
            defendPreSum[0] = 0;
        }
        else {
            attackPreSum[0] = 0;
            defendPreSum[0] = 1;
        }


        for (int i = 1; i < n; i++) {
            if(s.charAt(i) == '0'){
                attackPreSum[i] = (i+1) + attackPreSum[i-1];
                defendPreSum[i] = defendPreSum[i-1];
            }
            else {
                defendPreSum[i] =  (i+1) + defendPreSum[i-1];
                attackPreSum[i] = attackPreSum[i-1];
            }
        }

        //答题的时候，这里是int，只过了60%的案例，改成long就能过100%
        Long min = Long.MAX_VALUE;
        for (int pos = 0; pos <= n; pos++) {
            int w;
            int v;
            if(pos == 0){
                w = 0;
                v = defendPreSum[n-1];
            }
            else if(pos == n){
                w = attackPreSum[n-1];
                v = 0;
            }
            else {
                w = attackPreSum[pos-1];
                v = defendPreSum[n-1] - defendPreSum[pos];
            }

            min = Math.min(min, Math.abs(w-v));
        }

        System.out.println( min );
    }
}
