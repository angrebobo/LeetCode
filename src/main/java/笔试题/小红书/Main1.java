package 笔试题.小红书;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：镜像序列
 * 题目描述：一个序列的生成方式如下：
 * 序列生成需要一个基础序列A，这个序列由n个不大于100的数字组成，同时给定镜像复制次数n。
 * 然后对于A进行m次镜像复制，例如序列A={1，2，3}
 * 则一次镜像复制后得到的序列是{1，2，3，3，2，1}
 * 两次镜像复制得到的序列是B={1，2，3，3，2，1，1，2，3，3，2，1}
 * 现在给出你生成一个序列所需要的参数，请你计算该序列的第k位是多少。
 * 输人描述
 * 输入第一行包含三个整数n，m，k，含义如题所示。（1<=n<=100,1<=m<=60,1<=k<=1e18,部分数据k<10000）
 * 输入第二行包含n个正整数，每个正整数都不大于100，表示基础序列A。数字间有空格隔开
 * 输出仅包含一个正整数，即序列第k位的数字
 * @Data: Created in 15:30 2022/9/4
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        sc.nextLine();
        int[] nums = new int[n*2];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            nums[i] = temp;
            nums[n*2-1-i] = temp;
        }

        k %= (n * 2L);
        System.out.println( nums[(int) (k-1)] );
    }
}
