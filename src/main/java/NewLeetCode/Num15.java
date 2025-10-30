package NewLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
public class Num15 {

    /**
     * 双指针
     * 先对数组进行排序，然后固定一个数，使用双指针，移动两个数，判断和是否等于0
     * 如果小于0，则left++，如果大于0，则right--，如果等于0，则添加到结果中，并移动两个指针，直到left和right相遇
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        int[] sortNums = Arrays.stream(nums).sorted().toArray();
        int left, right;
        for (int i = 0; i < length-2; i++) {
            if(sortNums[i] > 0){
                break;
            }
            if(i>0 && sortNums[i] == sortNums[i-1]){
                continue;
            }
            left = i+1;
            right = length-1;
            while(left < right){
                int sum = sortNums[i] + sortNums[left] + sortNums[right];
                if (sum == 0){
                    res.add(Arrays.asList(sortNums[i], sortNums[left], sortNums[right]));
                    // 避免添加重复的元素
                    while (left < right && sortNums[left] == sortNums[left + 1]) {
                        left++;
                    }
                    while (left < right && sortNums[right] == sortNums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,1};
        System.out.println(new Num15().threeSum(nums));
    }
}
