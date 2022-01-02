/**
 * @author: HuangSiBo
 * @Description: 快速排序
 * @Data: Created in 16:34 2021/9/27
 */
public class QuickSort {

    public static void qucikSort(int[] nums, int left, int right){
        if(left >= right) return;
        int i = left;
        int j = right;
        int pivot = nums[i];

        while (i < j){
            while (i<j && nums[j]>pivot)
                j--;
            if(i < j){
                nums[i++] = nums[j];
            }

            while (i<j && nums[i]<pivot){
                i++;
            }
            if(i < j){
                nums[j--] = nums[i];
            }

        }
        nums[i] = pivot;
        qucikSort(nums, left, i-1);
        qucikSort(nums, i+1, right);

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,7,2,5};
        int len = nums.length;
        qucikSort(nums, 0, len-1);
        for (int i : nums){
            System.out.print(i + " ");
        }
    }
}
