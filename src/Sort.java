/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:31 2021/9/25
 */
public class Sort {

    /**
     * @Description 插入排序，时间复杂度为O(n2)
     * @param
     * @return
     */
    public static int[] insertSort(int[] nums){
        int len = nums.length;
        int temp = 0;
        int j;

        for (int i = 1; i < len; i++) {
            if(nums[i] < nums[i-1]){
                temp = nums[i];
                for ( j = i-1; nums[j] > temp ; j--) {
                    nums[j+1] = nums[j];
                }
                nums[j+1] = temp;
            }
        }

        return nums;
    }

    /**
     * @Description 折半插入
     * @param
     * @return
     */
    public static int[] insertSort(int[] nums, int n){
        int len = nums.length;
        int left, mid, right;
        int temp, j;

        for (int i = 1; i < len; i++) {
            temp = nums[i];
            left = 0;
            right = i-1;
            while (left <= right){
                mid = left + (right-left)/2;
                if(nums[mid] < nums[i]) left = mid+1;
                else right = mid-1;
            }
            for (j = i-1; j > right ; j--) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = temp;
        }
        return nums;
    }

    /**
     * @Description 快排
     * @param
     * @return
     */
    public static int[] quickSort(int[] nums){
        quickSortMethod(nums, 0, nums.length-1);
        return nums;
    }

    public static void quickSortMethod(int[] nums, int left, int right){
        if(left < right){
            int i = left;
            int j = right;
            int pivot = nums[i];

            while (i < j){
                while (i<j && nums[j]>=pivot){
                    j--;
                }
                if(i<j){
                    nums[i++] = nums[j];
                }

                while (i<j && nums[i]<=pivot){
                    i++;
                }
                if(i<j){
                    nums[j--] = nums[i];
                }
            }

            nums[i] = pivot;
            quickSortMethod(nums, left,i-1);
            quickSortMethod(nums, i+1, right);
        }
    }

    /**
     * @Description 堆排
     * @param
     * @return
     */
    public static void heapSort(int[] nums){
        int len = nums.length;
        // 将数组调整为堆的形式
        buildMaxHeap(nums);

        // 把堆顶元素和堆底元素互换，重新调整堆的结构
        for (int i = len-1; i > 0; i--) {
            System.out.println(nums[0]);
            int temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            // 这里第三个参数len要注意，已经把之前的堆顶元素放到堆底，在重新调整堆结构时不能去动之前的堆顶元素
            HeadAdjust(nums, 0, i);
        }
    }

    // 建造一个最大堆
    public static void buildMaxHeap(int[] nums){
        int len = nums.length;
        for (int i = (len-1)/2; i >= 0 ; i--) {
            HeadAdjust(nums, i, len);
        }
    }

    // 将k为根的树进行调节
    public static void HeadAdjust(int[] nums, int k, int len){
        int temp = nums[k];
        for (int i = 2*k + 1; i < len ; i = i*2 + 1) {
            if(i+1 < len-1 && nums[i] < nums[i+1])
                i++;
            if(temp > nums[i])
                break;
            else {
                nums[k] = nums[i];
                k = i;
            }
        }
        nums[k] = temp;
    }


    public static void main(String[] args) {
        int[] example = new int[]{53,17,78,9,45,65,87,32};
//        int[] nums = insertSort(example);
//        int[] nums = insertSort(example, example.length);
//        int[] nums = quickSort(example);
        heapSort(example);
        /*for(int i : nums){
            System.out.print(i + " ");
        }*/
    }
}
