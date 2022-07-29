package LeetCode;

public class Offer_Num76 {

    public static int findKthLargest(int[] nums, int k) {
        return quickSort(nums, k, 0, nums.length-1);
    }

    public static int quickSort(int[] nums, int k, int left, int right){
        int i = left, j = right;
        int pivot = nums[left];

        while(i < j){
            while(i<j && nums[j]>=pivot)
                j--;
            if(i < j)
                nums[i++] = nums[j];
            while(i<j && nums[i]<=pivot)
                i++;
            if(i < j)
                nums[j--] = nums[i];
        }
        nums[i] = pivot;

        if(i == nums.length-k) return nums[i];
        else if(i > nums.length-k) return quickSort(nums, k, left, i-1);
        else return quickSort(nums, k, i+1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }
}
