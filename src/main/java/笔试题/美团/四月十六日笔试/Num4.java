package 笔试题.美团.四月十六日笔试;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 给两个数字a和b
 * 可以对数字进行三种操作：
 * 1、将一个数字乘2
 * 2、将一个数字除2，向下取整
 * 3、将一个数字加1
 * 现在要求用最少的操作次数使得a==b，求次数
 * @Data: Created in 14:38 2022/4/16
 */
public class Num4 {
    // num最小操作次数
    static int num = Integer.MAX_VALUE;

    public static void dfs(int small, int large, int count){
        // count > num，剪枝
        if(count > num || small > large)
            return;
        if(small == large){
            num = Math.min(num, count);
            return;
        }

        // (large/2)要先递归，大数除2能更快使两数接近
        // 如果(large/2)放到下面递归，就容易爆栈
        dfs(small, large/2, count+1);
        dfs(small*2, large, count+1);
        dfs(small+1, large, count+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a > b){
            dfs(b, a, 0);
            System.out.println(num);
        }
        else if(a < b){
            dfs(a, b, 0);
            System.out.println(num);
        }
        else
            System.out.println("0");
    }
}
