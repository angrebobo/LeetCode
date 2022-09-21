package 笔试题.迅雷;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:58 2022/9/19
 */
public class Main1 {

    public static int count(int[] nums){
        int len = nums.length;
        if(len <= 1)
            return len;

        int maxLen = 0;

        boolean[][] dp = new boolean[len][len];
        for (int right = 1; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if(nums[left] == nums[right] && (right-left<=2 || dp[left+1][right-1]) && isAdd(nums, left, right)){
                    dp[left][right] = true;
                    maxLen = Math.max(maxLen, right-left+1);
                }
            }
        }
        return maxLen;
    }

    public static boolean isAdd(int[] nums, int left, int right){
        int mid;
        if((right-left+1)%2 == 1){
            mid = left + (right-left)/2;
        }
        else {
            mid = right/2;
        }

        for (int i = left; i <= mid-1; i++) {
            if(nums[left] > nums[left+1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            System.out.println(count(nums));
        }
    }
}
