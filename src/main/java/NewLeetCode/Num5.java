package NewLeetCode;

/**
 * 最长回文子串
 */
public class Num5 {

    /**
     * 动态规划
     * 思路可以参考 Num647
     */
    public static String longestPalindrome(String s) {
        int maxLength = 0;
        int maxLeft = 0;
        int maxRight = 0;
        int length = s.length();
        int[][] dp = new int[length][length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==1)){
                    dp[i][j] = 1;
                    if(j-i+1 > maxLength){
                        maxLength = j-i+1;
                        maxLeft = i;
                        maxRight = j;
                    }
                }
            }
        }

        return s.substring(maxLeft, maxRight+1);
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
