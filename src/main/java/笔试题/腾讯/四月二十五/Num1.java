package 笔试题.腾讯.四月二十五;

import java.util.Scanner;

/**
 * 题目链接
 * https://www.nowcoder.com/discuss/940859?channel=-1&source_id=profile_follow_post_nctrack
 */

public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] coin = new int[n];
        for(int i=0;i<n;i++)
            coin[i] = scanner.nextInt();

        long res = coin[k-1];
        long left = 0,right=0;
        if(res!=0){
            for(int i=k-2; i>=0 ; i--){
                left += coin[i];
                if(coin[i] <=1 ) break;
            }
            for(int i=k; i<n; i++){
                right += coin[i];
                if(coin[i] <=1 ) break;
            }
        }
        if(res==1)
            res += Math.max(left, right);
        else res = res+left+right;
        System.out.println(res);
    }
}
