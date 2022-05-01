package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:03 2021/4/14
 */
public class Num215 {

    /* 解法1，调用库函数 */
    /*public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }*/


    //解法2，利用快排的特性，每次partion后都会有一个元素到达它的最终位置
    /*public static int findKthLargest(int[] nums, int k){
        int index = 0;
        int left = 0;
        int right = nums.length - 1;
        int target = nums.length - k;

        while (true){
            index = partion(nums, left, right);
            if(index == target) {
                return nums[index];
            }
            else if(index < target){
                left = index + 1;
            }
            else {
                right = index - 1;
            }
        }
    }

    public static int partion(int[] nums, int left, int right){
        //这4行代码非常关键，能大大提升运行效率
        //快排在序列比较有序的时候时间复杂度会比较高，因此把第一个元素和后面一个随机元素交换，使序列变得更加无序
        int RandomStart = (int) (Math.random() * (right-left) + left);
        int temp = nums[left];
        nums[left] = nums[RandomStart];
        nums[RandomStart] = temp;

        int pivot = nums[left];
         while (left < right){
            while (left < right && nums[right] >= pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }*/

    /*public static int findKthLargest(int[] nums, int k){
        int len = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            queue.add(nums[i]);
        }
        for (int i = 1; i <= len-k ; i++) {
            queue.poll();
        }
        return  queue.peek();
    }
*/

    //2021.09.17日写
    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int temp,index = 0;

            for (int i = 0; i < len; i++) {
                temp = nums[i];
                index = 0;
                for (int j = i+1; j < len; j++) {
                    if(nums[j] > temp){
                        temp = nums[j];
                        index = j;
                    }
                }
                nums[index] = nums[i];
                nums[i] = temp;
                if(i+1 == k)
                    return temp;
            }
            return -1;
        }
    }

    //2022.03.20写
    public static int findKthLargest(int[] nums, int k){
        int left = 0;
        int right = nums.length-1;
        int target = nums.length-k;

        while (true){
            int index = qucikSort(nums, left, right);
            if(index == target)
                return nums[index];
            else if(index < target){
                left = index+1;
            }
            else {
                right = index-1;
            }
        }
    }

    public static int qucikSort(int[] nums, int left, int right){
        //随机选择pivot，增强算法的鲁棒性 00
        int randomStart = (int) (left + Math.random()*(right-left));
        int temp = nums[left];
        nums[left] = nums[randomStart];
        nums[randomStart] = temp;

        int pivot = nums[left];

        while (left < right){
            while (left < right && nums[right] > pivot){
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot){
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = pivot;
        return left;
    }


    public static void main(String[] args) {

        int[] input = {5,2,4,1,3,6,0};
        int k = 4;
        Solution solution = new Solution();
//        System.out.println(solution.findKthLargest(input, k));

        System.out.println( findKthLargest(input, k) );
    }
}
