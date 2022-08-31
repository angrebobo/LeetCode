package 笔试题.携程;

import java.util.Scanner;

public class Main4 {

    static int smo;
    public static void dfs1(int index, int[] nums, int val){
        if(val > smo)
            return;

        smo = val;

        nums[index] += 1;
        dfs1(index, nums, claculate(nums));
        nums[index] -= 1;
    }

    public static void dfs2(int index, int[] nums, int val){
        if(val > smo)
            return;

        smo = val;

        nums[index+1] -= 1;
        dfs1(index, nums, claculate(nums));
        nums[index+1] += 1;
    }

    public static void dfs3(int index, int[] nums, int val){
        if(val > smo)
            return;

        smo = val;

        nums[index] -= 1;
        dfs1(index, nums, claculate(nums));
        nums[index] += 1;
    }

    public static void dfs4(int index, int[] nums, int val){
        if(val > smo)
            return;

        smo = val;

        nums[index+1] += 1;
        dfs1(index, nums, claculate(nums));
        nums[index+1] -= 1;
    }

    public static int claculate(int[] nums){
        int smo = 0;
        for (int i = 0; i < nums.length-1; i++) {
            smo = Math.max(smo, Math.abs(nums[i]-nums[i+1]));
        }
        return smo;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }


        smo = 0;
        int index = 0;
        for (int i = 0; i < n-1; i++) {
            int temp = Math.abs(nums[i]-nums[i+1]);
            if(temp > smo){
                smo = temp;
                index = i;
            }
        }
        dfs1(index, nums, smo);
        dfs2(index, nums, smo);
        dfs3(index, nums, smo);
        dfs4(index, nums, smo);
        System.out.println(smo);
    }
}
