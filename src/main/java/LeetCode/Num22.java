package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * 一个合法的括号组合：
 * 1、左右括号数相等
 * 2、所有前缀中，左括号数>=有括号数
 * @Data: Created in 23:53 2021/5/17
 */
public class Num22 {
    static class Solution {

        public List<String> generateParenthesis(int n) {
            List<String> list = new LinkedList<>();
            if(n == 0)
                return list;
            //方法1
            //dfs("", n, n, list);

            //方法2
            dfs("", 0, 0, list, n);

            return list;
        }

        //方法1，减法
        /*public void dfs(String curStr, int left, int right, List<String> list){
            if(left==0 && right==0){
                list.add(curStr);
            }
            if(left > right)
                return;

            if(left > 0)
                dfs(curStr+"(", left-1, right, list);
            if(right > 0)
                dfs(curStr+")", left, right-1, list);
        }*/


        /**
         *
         * @param curStr 当前字符串
         * @param left 左括号的个数
         * @param right 右括号的个数
         * @param list 存结果
         * @param n
         */
        public void dfs(String curStr, int left, int right, List<String> list, int n){
            if(left==n && right==n)
                list.add(curStr);

            //当右括号个数大于左括号个数，结束
            if(right > left)
                return;

            if(left < n)
                dfs(curStr+"(", left+1, right, list, n);
            if(right < n)
                dfs(curStr+")", left, right+1, list, n);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(n));
    }
}
