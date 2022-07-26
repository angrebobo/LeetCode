/**
 * @author: HuangSiBo
 * @Description: 几种排序算法
 * 口诀：
 * 不稳定的排序算法:快（快排）些（希尔）选（选择）一堆（堆排）
 * 插入排序：直接插入排序，折半插入排序
 * 交换排序：冒泡，快排
 * 选择排序：简单选择排序，堆排
 * 其他：归并排序
 * @Data: Created in 19:31 2021/9/25
 */
public class 排序算法 {

    /**
     * @Description 直接插入排序，时间复杂度为O(n^2)
     * @param
     * @return
     */
    public static int[] insertSort(int[] nums){
        int len = nums.length;
        int temp;
        int j;

        for (int i = 1; i < len; i++) {
            // nums[0]~nums[i-1]是有序的
            // 当nums[i] 小于 nums[i-1], 需要插入
            if(nums[i] < nums[i-1]){
                temp = nums[i];
                //找到位置j，nums[i] 插入到位置j后，nums[0]~nums[i]是有序的
                for ( j = i-1; j >= 0 && nums[j] > temp; j--) {
                    nums[j+1] = nums[j];
                }
                nums[j+1] = temp;
            }
        }

        return nums;
    }

    /**
     * @Description 折半插入,时间复杂度为O(n * log2^n)
     * @param
     * @return
     */
    public static int[] divisionInsertSort(int[] nums){
        int len = nums.length;
        int left, mid, right;
        int temp, j;

        for (int i = 1; i < len; i++) {
            temp = nums[i];
            left = 0;
            right = i-1;
            if(temp < nums[i-1]){
                // 二分查找，最后left的位置就是插入的位置
                while (left <= right){
                    mid = left + (right-left)/2;
                    if(nums[mid] < nums[i]) left = mid+1;
                    else right = mid-1;
                }
                for (j = i-1; j >= left ; j--) {
                    nums[j+1] = nums[j];
                }
                nums[left] = temp;
            }
        }
        return nums;
    }

    /**
     * @Description 快排,时间复杂度为O(n * log2^n),不稳定排序
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

    public static void mergeSort(int[] nums, int left, int right){
        if(left < right){
            int mid = left + (right-left)/2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid+1, right);
            merge(nums, left, mid, mid+1, right);
        }
    }

    public static void merge(int[] nums, int left1, int right1, int left2, int right2){
        int[] temp = new int[nums.length];
        int i = left1;
        int j = left2;
        int index = 0;
        while (i<=right1 && j<=right2){
            if(nums[i] < nums[j])
                temp[index++] = nums[i++];
            else
                temp[index++] = nums[j++];
        }
        while (i<=right1) temp[index++] = nums[i++];
        while (j<=right2) temp[index++] = nums[j++];

        for (int k = 0; k < index; k++) {
            nums[left1 + k] = temp[k];
        }
    }


    public static void main(String[] args) {
        int[] example = new int[]{53,17,78,9,45,65,87,32,32,87};
        quickSort(example);
//        heapSort(example);
//        mergeSort(example, 0, example.length-1);
//        insertSort(example);
//        divisionInsertSort(example);
        for(int i : example){
            System.out.print(i + " ");
        }
    }
}
