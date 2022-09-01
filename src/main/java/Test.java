/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:36 2022/8/28
 */
public class Test {

    public static void quickSort(int[] nums){
        qucik(nums, 0, nums.length-1);
    }

    public static void qucik(int[] nums, int left, int right){
        if(left < right){
            int i = left;
            int j = right;
            int pivot = nums[i];

            while (i<j){
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
            qucik(nums, left, i-1);
            qucik(nums, i+1, right);
        }
    }

    public static void main(String[] args) {
        int[] example = new int[]{53,17,78,9,45,65,87,32,32,87};
        quickSort(example);
        for (int i : example) {
            System.out.println(i);
        }

    }
}
