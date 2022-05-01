package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:47 2022/4/20
 */
public class Num1143 {
    static class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            String text1_copy = " " + text1;
            String text2_copy = " " + text2;
            int len1 = text1_copy.length();
            int len2 = text2_copy.length();
            int[][] dp = new int[len1][len2];

            for (int i = 0; i < len2; i++) {
                dp[0][i] = 0;
            }
            for (int i = 0; i < len1; i++) {
                dp[i][0] = 0;
            }

            for (int i = 1; i < len1; i++) {
                for (int j = 1; j < len2; j++) {
                    if(text1_copy.charAt(i) == text2_copy.charAt(j))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

            return dp[len1-1][len2-1];
        }
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";

        Solution solution = new Solution();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }
}
