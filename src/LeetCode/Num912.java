package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:25 2021/9/18
 */
public class Num912 {

    static class Solution {

        /**
         * @Description 冒泡排序
         * @param
         * @return
         */
        /*public int[] sortArray(int[] nums) {
            int len = nums.length;
            int temp;

            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    if(nums[j] < nums[i]){
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }

            return nums;
        }*/

        /**
         * @Description 选择排序
         * @param
         * @return
         */
        /*public int[] sortArray(int[] nums){
            int len = nums.length;
            int min_index = 0, temp;

            for (int i = 0; i < len; i++) {
                min_index = i;
                for (int j = i+1; j < len; j++) {
                    if(nums[j] < nums[min_index])
                        min_index = j;
                }
                temp = nums[i];
                nums[i] = nums[min_index];
                nums[min_index] = temp;
            }
            return nums;
        }*/

        /**
         * @Description 直接插入排序
         * @param
         * @return
         */
        /*public int[] sortArray(int[] nums){
            int len = nums.length;
            int temp, j;

            for (int i = 0; i < len; i++) {
                temp = nums[i];
                j = i-1;
                while (j>=0 && nums[j]>temp){
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    j--;
                }
            }
            return nums;
        }*/

        /**
         * @Description 折半插入排序
         * @param
         * @return
         */
        /*public int[] sortArray(int[] nums){
            int len = nums.length;
            int temp,low,high,mid;

            for (int i = 0; i < len; i++) {
                temp = nums[i];
                low = 0;
                high = i-1;
                while (low <= high){
                    mid = low+(high-low)/2;
                    if(nums[mid] > temp)
                        high = mid-1;
                    else low = mid+1;
                }
                for (int j = i; j > low ; j--) {
                    nums[j] = nums[j-1];
                }
                nums[low] = temp;
            }
            return nums;
        }*/

        /**
         * @Description 快速排序
         * @param
         * @return
         */
        public int[] sortArray(int[] nums){
            quickSort(nums, 0, nums.length-1);
            return nums;
        }

        public void quickSort(int[] nums, int left, int right){
            if(left < right){
                int i = left;
                int j = right;
                int pivot = nums[i];
                while (i < j){
                    while (i<j && nums[j]>=pivot)
                        j--;
                    if(i<j)
                        nums[i++] = nums[j];

                    while (i<j && nums[i]<=pivot)
                        i++;
                    if(i<j)
                        nums[j--] = nums[i];
                }
                nums[i] = pivot;
                quickSort(nums, left, i-1);
                quickSort(nums, i+1, right);
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = new int[]{3,1,2,5};
        Solution solution = new Solution();
        for(int i : solution.sortArray(nums)){
            System.out.print(i + " ");
        }
    }
}
