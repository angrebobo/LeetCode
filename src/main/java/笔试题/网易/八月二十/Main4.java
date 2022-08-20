package 笔试题.网易.八月二十;

import java.util.Scanner;

public class Main4 {

    public static int count(int[] nums){
        int len = nums.length;
        int count = 0;
        for (int i = 1; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if(nums[i]==nums[k] && nums[i]>nums[j])
                        count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(count(nums));
    }
}
