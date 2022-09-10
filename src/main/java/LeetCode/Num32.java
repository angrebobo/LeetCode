package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:28 2022/7/3
 */
public class Num32 {
    static class Solution {
        /*public int longestValidParentheses(String s) {
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
        }*/

        // 2022.09.07写
        public static int longestValidParentheses(String s) {
            int len = s.length();
            if(len == 0) return 0;
            char[] chars = s.toCharArray();
            // dp[i]表示已chars[i]为结尾的最长有效字符串。要牢记dp的含义
            int[] dp = new int[len];
            dp[0] = 0;
            int max = 0;
            for (int i = 1; i < s.length(); i++) {
                if(chars[i] == ')'){
                    if(chars[i-1] == '(')
                        dp[i] = i-2>=0 ? dp[i-2]+2 : 2;
                    else if(chars[i-1] == ')'){
                        if(i-dp[i-1]-1 >=0 && chars[i-dp[i-1]-1] == '(')
                            dp[i] = i-dp[i-1]-2>=0 ? (dp[i-dp[i-1]-2] + dp[i-1] + 2) : (dp[i-1] + 2) ;
                    }
                }

                max = Math.max(max, dp[i]);
            }

            return max;
        }
    }

    public static void main(String[] args) {
        String s = "()(())";
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses(s));
    }
}
