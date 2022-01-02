package leetcode;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/22 15:58
 */

public class Num704 {

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle;
        while (left <= right){
            middle = left + (right-left)/2;
            if(nums[middle] == target)
                return middle;

            if(target < nums[middle])
                right = middle - 1;
            else
                left = middle + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,3,5,9,12};
        int target = 10;
        System.out.println(search(nums, target));
    }
}
