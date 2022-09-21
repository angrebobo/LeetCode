package 笔试题.华为.九月二十一;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:08 2022/9/21
 */
public class Main {

    public static int calculate(int n, long[] nums, long total, long max){
        long temp = total/n;
        for (long i = temp; i <= max; i++) {
            int sum = 0;
            for (long num : nums) {
                sum += Math.min(num, i);
            }
            if(sum > total){
                return (int) (i-1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        long sum = 0;
        long max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        long total = sc.nextLong();
        if(sum < total){
            System.out.println(-1);
        }
        else {
            System.out.println(calculate(n, nums, total, max));
        }
    }
}

//6
//3 3 8 7 10 15
//40
