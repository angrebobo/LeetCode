package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:28 2022/7/3
 */
public class Num32 {
    static class Solution {
        /*// 这傻逼题目题意也不讲清楚
        public int longestValidParentheses(String s) {
            int len = s.length();
            int start = 0, end = 0;
            int res = 0;
            while (end < len){
                if(!isVal(s, end)){
                    start = end;
                    while (start<len && s.charAt(start) == ')'){
                        start++;
                        end++;
                    }
                }
                else if(s.charAt(end) == ')'){
                    res = Math.max(res, end-start+1);
                }

                end++;
            }

            return res;
        }

        public boolean isVal(String s, int end){
            if(end < 1)
                return false;
            if(s.charAt(end-1)=='(' && s.charAt(end)==')')
                return true;
            else if(s.charAt(end-1)==')' && s.charAt(end)=='(')
                return true;
            else
                return false;
        }*/

        public int longestValidParentheses(String s) {
            int len = s.length();
            int[] dp = new int[len];
            int res = 0;
            for (int i = 0; i < len; i++) {
                if(s.charAt(i) == ')'){
                    if(i-1>=0 && s.charAt(i-1)=='('){
                        if(i-2>=0)
                            dp[i] = dp[i-2] + 2;
                        else
                            dp[i] = 2;
                    }
                    else if(i-1>=0 && s.charAt(i-1)==')'){
                        if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                            if(i-dp[i-1]-2>=0)
                                dp[i] = dp[i-1] + 2 + dp[i-dp[i-1]-2];
                            else
                                dp[i] = dp[i-1] + 2;
                        }
                    }
                    res = Math.max(res, dp[i]);
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        String s = "()(())";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s));
    }
}
