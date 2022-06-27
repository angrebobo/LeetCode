package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 这种题只能死记硬背，因为使用动态规划写的，和原题其实已经没有什么关系了
 * @Data: Created in 13:12 2022/6/27
 */
public class Num72 {
    static class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1+1][len2+1];
            for (int i = 1; i < len1+1; i++) {
                dp[i][0] = dp[i-1][0]+1;
            }
            for (int j = 1; j < len2+1; j++) {
                dp[0][j] = dp[0][j-1]+1;
            }

            for (int i = 1; i < len1+1; i++) {
                for (int j = 1; j < len2+1; j++) {
                    if(word1.charAt(i-1) == word2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1];
                    else
                        dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }

            return dp[len1][len2];
        }
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        Solution solution = new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }
}
