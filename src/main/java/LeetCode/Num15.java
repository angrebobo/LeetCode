package LeetCode;

import java.util.*;
/**
 * @author: HuangSiBo
 * @Description: 三数之和，用排序和双指针
 * @Data: Created in 10:30 2021/4/7
 */
public class Num15 {

    /*public static List<List<Integer>> threeSum(int[] nums) {
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
    }*/

    // 2022.07.31写
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();

            for(int i = 0;i<nums.length-1;i++){
                if(nums[i] > 0)
                    break;
                if(i >= 1 && nums[i] == nums[i-1])
                    continue;

                int left = i+1;
                int right = nums.length-1;
                while(left < right){
                    int temp = nums[i] + nums[left] + nums[right];
                    if(temp == 0){
                        path.add(nums[i]);
                        path.add(nums[left]);
                        path.add(nums[right]);
                        ans.add(new ArrayList<>(path));
                        path.clear();

                        while(left<right && nums[left]==nums[left+1]) left++;
                        while(left<right && nums[right]==nums[right-1]) right--;
                        left++;
                        right--;
                    }
                    else if(temp > 0)
                        right--;
                    else left++;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};

//        List<List<Integer>> ans = threeSum(nums);
//        System.out.println(ans);

        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums).toString());
    }
}
