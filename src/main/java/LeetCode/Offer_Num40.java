package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

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

        public int[] getLeastNumbers(int[] arr, int k){
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int i = 0; i < arr.length; i++) {
                queue.add(arr[i]);
            }
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.poll();
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8)));
    }
}
