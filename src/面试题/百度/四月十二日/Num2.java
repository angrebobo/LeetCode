package 面试题.百度.四月十二日;

import javax.print.DocFlavor;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 给你两个等长的数组 A 和 B，可以使用一次 “魔法” 将 A[i] 变成 B[i]；
 * 问你把 A 数组变成单调递增的数组最少需要多少次魔法，如果不能就输出 -1
 * @Data: Created in 16:17 2022/4/19
 */
public class Num2 {

    static int len;
    static int ans = Integer.MAX_VALUE;
    public static void dfs(int[] A, int[] B, int index, int count){
        if(index != 0 ){
            if(index > len)
                return;
            if(index==len){
                ans = Math.min(ans, count);
                return;
            }
            if(A[index] <= A[index-1] && B[index] <= A[index-1])
                return;
        }

        if(A[index] > A[index-1])
            dfs(A, B, index+1, count);

        int temp = A[index];
        A[index] = B[index];
        dfs(A, B, index+1, count+1);
        A[index] = temp;
    }

    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        len = n;
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            B[i] = sc.nextInt();
        }*/
        int[] A = new int[]{1, 2, 1};
        int[] B = new int[]{0, 3, 4};
        len = A.length;
        dfs(A, B, 0, 0);
        System.out.println(ans);
    }
}
