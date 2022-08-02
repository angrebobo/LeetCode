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
        List<String> res;
        public List<String> letterCasePermutation(String s) {
            res = new ArrayList<>();
            StringBuilder builder = new StringBuilder();
            dfs(s, 0, builder);
            return res;
        }

        public void dfs(String s, int index, StringBuilder builder){
            if(index == s.length()){
                res.add(String.valueOf(builder));
                return;
            }

            char c = s.charAt(index);
            if('a' <= c && c <= 'z'){
                builder.append(Character.toChars(c-32));
                dfs(s, index+1, builder);
                builder.deleteCharAt(builder.length()-1);
            }

            builder.append(c);
            dfs(s, index+1, builder);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCasePermutation("a1b2"));
    }
}
