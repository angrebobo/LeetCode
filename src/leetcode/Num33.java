package leetcode;

import javax.smartcardio.ATR;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:03 2021/5/21
 */
public class Num33 {
    /*public static int search(int[] nums, int target) {
        if(target < nums[0]){
            int i = 1;
            for (; i <= nums.length-1; i++){
                if(nums[i] > nums[i-1]) continue;
                else break;
            }
            if(i == nums.length) return -1;

            for (int j = i; j < nums.length; j++) {
                if(nums[j] == target) return j;
            }
            return -1;
        }
        else {
            int i = 0;
            for (; i < nums.length; i++) {
                if(target == nums[i]) return i;
            }
        }
        return -1;
    }*/

    public static int search(int[] nums, int target) {
        if(nums.length == 1)
            return target==nums[0] ? 0 : -1;

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target)
                return mid;

            //数组0-mid部分有序
            if(nums[0] <= nums[mid]){
                if(nums[0]<=target && target<nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            //数组mid-(nums.length-1)部分有序
            else {
                if(nums[mid]<target && target<=nums[nums.length-1])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] num = {3,1};
        int target = 1;
        System.out.println(search(num, target));
    }
}
