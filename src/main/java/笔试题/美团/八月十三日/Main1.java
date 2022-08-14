package 笔试题.美团.八月十三日;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 魔法外卖，在0时刻拿到n份外卖，
 * 正常送：每次送外卖都要花费x的时间，（一次只能送一份），
 * 魔法送，异地传送不花时间，在同一时刻收到若干份外卖，求最少使用魔法的次数，
 * 要保证所有外卖都不超时
 * 输入：
 * n（n份外卖）t（送一份外卖的时间）
 * n个数（n份外卖的截止时间）
 * 输出：
 * 最少使用魔法的次数
 */
public class Main1 {

    public static int count(long n, int t, long[] time){
        int order = 1;
        int index = 0;
        int count = 0;
        while (order <= n){
            int end = t*order;
            for (; index < n; index++) {
                if(time[index] < end)
                    count++;
                else
                    break;
            }
            order++;
            index++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int t = sc.nextInt();
        sc.nextLine();
        long[] time = new long[(int) n];
        for (int i = 0; i < n; i++) {
            time[i] = sc.nextLong();
        }
        // 要对截至时间排序，这里没排，只过了27%
        Arrays.sort(time);
        System.out.println(count(n, t, time));
    }
}
