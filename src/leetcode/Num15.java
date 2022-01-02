package leetcode;

import java.util.*;
/**
 * @author: HuangSiBo
 * @Description: 三数之和，用排序和双指针
 * @Data: Created in 10:30 2021/4/7
 */
public class Num15 {

    public static List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;

        //排序
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        if(len == 0 || len < 3)
            return ans;

        for (int i = 0; i < len; i++) {
            //如果nums[i]>0,后面的数全为正数，加起来一定大于零
            if(nums[i] > 0)
                break;
            if(i >= 1 && nums[i] == nums[i-1])
                continue;

            //L是左指针，R是右指针
            int L = i + 1;
            int R = len -1;
            while (L < R) {
                int tempSum = nums[i]+nums[L]+nums[R];
                if(tempSum == 0){
                    List<Integer> part = new ArrayList<>();
                    part.add(nums[i]);
                    part.add(nums[L]);
                    part.add(nums[R]);
                    ans.add(part);

                    //跳过重复的数
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if(tempSum > 0)
                    R--;
                else if(tempSum < 0)
                    L++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,0,2,2};

        List<List<Integer>> ans = threeSum(nums);
        System.out.println(ans);
    }
}
