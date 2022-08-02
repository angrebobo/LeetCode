package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:11 2022/8/2
 */
public class Num784 {

    static class Solution {
        public List<String> letterCasePermutation(String s) {
            List<String> res = new ArrayList<>();
            char[] chars = s.toCharArray();
            dfs(chars, 0, res);
            return res;
        }

        public void dfs(char[] chars, int index, List<String> res){
            if(index == chars.length){
                res.add(new String(chars));
                return;
            }

            dfs(chars, index + 1, res);

            if (Character.isLetter(chars[index])) {
                chars[index] ^= 32;
                dfs(chars, index + 1, res);
                chars[index] ^= 32;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCasePermutation("C"));
    }
}
