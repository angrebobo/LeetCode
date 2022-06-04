package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:18 2022/6/4
 */
public class Offer_Num51 {
    static class Solution {

        int reversePairsCount;

        //用归并排序
        public int reversePairs(int[] nums) {
            reversePairsCount = 0;
            mergeSort(nums, 0, nums.length-1, new int[nums.length]);
            return reversePairsCount;
        }

        public void mergeSort(int[] nums, int left, int right, int[] temp){
            if(left < right){
                int mid = left + (right-left)/2;
                mergeSort(nums, left, mid, temp);
                mergeSort(nums, mid+1, right, temp);
                merge(nums, left, mid, mid+1, right, temp);
            }
        }

        public void merge(int[] nums, int left1, int right1, int left2, int right2, int[] temp){
            int i = left1;
            int j = left2;
            int k = 0;

            while (i <= right1 && j <= right2){
                // 注意！！！这里的等号要加上。
                // 如果只是写归并排序，这个等号加或不加结果不会变
                // 但是现在是nums[i] > nums[j]，才能去计算逆序对的值，所以等号要加上
                if (nums[i] <= nums[j])
                    temp[k++] = nums[i++];
                else {
                    temp[k++] = nums[j++];
                    reversePairsCount += (right1-i+1);
                }
            }

            while (i <= right1) temp[k++] = nums[i++];
            while (j <= right2) temp[k++] = nums[j++];

            for (int l = 0; l < k; l++) {
                nums[left1+l] = temp[l];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,3,1};
        Solution solution = new Solution();
        System.out.println(solution.reversePairs(nums));
    }
}
