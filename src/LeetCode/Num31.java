package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:09 2021/5/28
 */
public class Num31 {
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        boolean flag = false;
        for (int i = len-1; i >= 1; i--) {
            if(nums[i] > nums[i-1]){
                int temp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = temp;
                flag = true;
                break;
            }
        }
        if(!flag){
            int l = 0;
            int r = len-1;
            while (l<r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
    }

    /**
     * @Description 2021.10.06写
     * @param
     * @return
     */
    static class Solution {
        public void nextPermutation(int[] nums) {
            int len = nums.length;
            int i;
            int k;

            for (i = len-1; i >= 1; i--) {
                if(nums[i-1] < nums[i])
                    break;
            }

            if(i == 1){

            }

            for (k = len-1; k > i-1; k--) {
                if(nums[i-1] < nums[k]){
                    break;
                }
            }

            int temp = nums[i-1];
            nums[i-1] = nums[k];
            nums[k] = temp;

            int count = 0;
            for (int j = i; j < len; j++) {
                if(count >= (len-i)/2)
                    break;

                int temp1 = nums[j];
                nums[j] = nums[len-1-count];
                nums[len-1-count] = temp1;

                count++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1};
        // nextPermutation(nums);
        Solution solution = new Solution();
        solution.nextPermutation( nums );
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
