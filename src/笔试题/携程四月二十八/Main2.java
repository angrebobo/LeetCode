package 笔试题.携程四月二十八;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:33 2022/4/28
 */
public class Main2 {
    static int a;
    static int b;
    static int maxCount = Integer.MIN_VALUE;
    public static void dfs(int n, int m, int count){
        if(n < 0)
            return;
        if(m < 0)
            return;
        if(count > maxCount)
            maxCount = count;

        dfs(n-2,m-1,count+a);

        dfs(n-1,m-2,count+b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();

        dfs(n,m,0);
        System.out.println(maxCount);
    }
}
