package 笔试题.小红书;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：乘积为7
 * 题目描述：给定n个整数a1, a2, a3...an。每次操作可以选择其中一个数，并将这个数加上1或者减去1。
 * 小红非常喜欢7这个数，他想知道至少需要多少次操作可以使这n个数的乘积为7？
 * 输入描述
 * 第一行输入一个正整数n，表示整数的个数。
 * 第二行输入n个整数a1, a2, a3...an，其中ai表示第i个数。
 * 5
 * -6 0 2 -2 3
 * 输出描述
 * 输出一个整数，表示将所有数的乘积变为7最少需要的操作次数。
 * 6
 *
 * 思路：贪心。7是素数，因子只有1和7。所以将最大的正数变为7，或者将最大的负数变为-7。其余的数变为1或者-1。
 * @Data: Created in 15:30 2022/9/4
 */
public class Main2 {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for(int i=0;i<len;i++)
            nums[i] = in.nextInt();

        Arrays.sort(nums);
        // 要用long，int可能溢出
        long ans = 0;
        // 记录负数的个数
        int neg = 0;
        int index;
        // 找到绝对值最大的数
        // 如果是负数，变为-7
        if(nums[0]<0 && -nums[0]>nums[nums.length-1]){
            neg+=1;
            ans += Math.abs(-7 - nums[0]);
            index = 0;
        }
        // 如果是正数，变为7
        else {
            ans += Math.abs(7 - nums[nums.length-1]);
            index = nums.length-1;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i != index){
                // 其余的数，如果小于0就变成-1，如果大于0就变成1
                if(nums[i] < 0){
                    ans += Math.abs(-1 - nums[i]);
                    neg += 1;
                }
                else
                    ans += Math.abs(1 - nums[i]);
            }
        }

        // 记录数组中负数的个数，如果是奇数，那就把一个-1变成1，多两次操作
        if(neg%2 != 0)
            ans += 2;
        System.out.println(ans);
    }
}
