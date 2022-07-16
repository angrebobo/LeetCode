package LeetCode;

import java.util.ArrayList;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:40 2022/7/16
 */
public class Offer_Num62 {
    static class Solution {
        /*public int lastRemaining(int n, int m) {
            int[] nums = new int[n];
            Arrays.fill(nums, 1);
            int count = 1;
            int sum = n;
            for (int i = 0;; i = (i+1)%n) {
                if(sum == 1)
                    break;
                if(nums[i] != 1)
                    continue;
                if(count != m){
                    count++;
                }
                else {
                    nums[i] = 0;
                    count = 1;
                    sum--;
                }
            }

            for (int i = 0; i < n; i++) {
                if(nums[i] == 1)
                    return i;
            }

            return -1;
        }*/

        public int lastRemaining(int n, int m){
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }

            int index = 0;
            while (list.size() > 1){
                    index = (index + m - 1)%n;
                    list.remove(index);
                    n--;
            }
            return list.get(0);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        Solution solution = new Solution();
        System.out.println(solution.lastRemaining(n, m));
    }
}
