package NewLeetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * 暴力遍历时间复杂度在O（n2），用哈希表查找的时间复杂度是O（1）
 * https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked
 * 题解:https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked
 */
public class Num1 {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i, map.get(target-nums[i])};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,0,432,3,-7,11,15};
        System.out.println(Arrays.toString(new Num1().twoSum(nums, 10)));
    }
}
