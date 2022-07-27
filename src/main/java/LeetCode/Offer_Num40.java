package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:27 2022/5/28
 */
public class Offer_Num40 {
    static class Solution {
        //方法1，冒泡
        /*public int[] getLeastNumbers(int[] arr, int k) {
            int len = arr.length;
            int[] ans = new int[k];

            for (int i = 0; i < k; i++) {
                for (int j = len-1; j > i; j--) {
                    if(arr[j] < arr[j-1]){
                        swap(arr, j, j-1);
                    }
                }
                ans[i] = arr[i];
            }

            return ans;
        }

        public void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }*/

        // 堆排，用优先队列
        /*public int[] getLeastNumbers(int[] arr, int k){
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }

            return res;
        }*/

        // 快排
        public int[] getLeastNumbers(int[] arr, int k){
            if(arr.length == 0 || k == 0)
                return new int[0];
            if(k > arr.length)
                return arr;

            return quickSortMethod(arr, k-1, 0, arr.length-1);
        }

        public int[] quickSortMethod(int[] arr, int k,int left, int right){
            int i = left;
            int j = right;
            int pivot = arr[left];

            while(i < j){
                while(i<j && arr[j]>=pivot)
                    j--;
                if(i<j)
                    arr[i++] = arr[j];
                while(i<j && arr[i]<=pivot)
                    i++;
                if(i<j)
                    arr[j--] = arr[i];
            }

            arr[i] = pivot;
            if(i < k) return quickSortMethod(arr, k, i+1, right);
            if(i > k) return quickSortMethod(arr, k, left, i-1);
            return Arrays.copyOfRange(arr, 0, i+1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{3,2,1}, 2)));
    }
}
