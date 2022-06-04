package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:16 2022/6/2
 */
public class Num315 {
    static class Solution {
        //最傻逼的方法，超时了
        /*public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new LinkedList<>();

            for (int i = 0; i < nums.length; i++) {
                int count = 0;
                for (int j = i+1; j < nums.length ; j++) {
                    if(nums[j] < nums[i])
                        count++;
                }
                res.add(count);
            }

            return res;
        }*/

        //用归并排序
        /*public List<Integer> countSmaller(int[] nums){

        }

        int
        public void mergeSort(int[] nums){

        }*/
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,-1};
        Solution solution = new Solution();
//        System.out.println(solution.countSmaller(nums).toString());
    }
}
