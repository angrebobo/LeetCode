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

        //换一号大礼包
        dfs(n-2,m-1,count+a);

        //换二号大礼包
        dfs(n-1,m-2,count+b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //苹果数量
        int n = sc.nextInt();
        //桃子数量
        int m = sc.nextInt();
        //一号大礼包价值
        a = sc.nextInt();
        //二号大礼包价值
        b = sc.nextInt();

        dfs(n,m,0);
        System.out.println(maxCount);
    }
}
