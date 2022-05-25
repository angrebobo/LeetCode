package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:11 2022/5/25
 */
public class Offer_Num17 {

    static class Solution {
        public int[] printNumbers(int n) {
            char[] nums = new char[]{'0','1','2','3','4','5','6','7','8','9'};
            StringBuffer path = new StringBuffer();
            List<String> res = new LinkedList<>();
            backTrace(nums, path, res, n);
            res.remove(0);

            return res.stream().mapToInt(Integer::parseInt).toArray();
        }

        public static void backTrace(char[] nums,  StringBuffer path, List<String> res, int n){
            if(path.length() == n){
                res.add(path.toString());
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                path.append(nums[i]);
                backTrace(nums, path, res, n);
                path.deleteCharAt(path.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.printNumbers(1)));
    }
}
