package 笔试题.网易.八月二十;

import java.util.Scanner;

public class Main2 {

    static int ans;
    public static int count(long[] nums){
        int len = nums.length;
        ans = 0;
        for (int i = 1; i < len-1; i++) {
            if(nums[i+1] != nums[i-1]){
                ans += Math.abs(nums[i+1]-nums[i-1]);
                if(nums[i+1]>nums[i-1]){
                    nums[i-1] = nums[i+1];
                    gg(nums, i-1);
                }
                else {
                    nums[i+1] = nums[i-1];
                }
            }
        }
        return ans;
    }

    public static void gg(long[] nums, int index){
        for (int i = index-1; i >=0; i--) {
            if(i-1>=0 && i+1<nums.length && nums[i-1] != nums[i+1]){
                ans += nums[i+1]-nums[i-1];
                nums[i-1] = nums[i+1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

//        int[] nums = new int[]{1,1,4,3,1,4};
        System.out.println(count(nums));
    }
}

//6
//1 1 4 6 1 4