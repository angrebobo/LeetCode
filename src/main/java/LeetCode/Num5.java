package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:50 2021/10/3
 */
public class Num5 {
    /*public static String longestPalindrome(String s) {
        int len = s.length();
        *//* dp[i][j]==1时表示s[i]到s[j]是回文串 *//*
        int[][] dp = new int[len][len];
        int maxlen = 0;
        String ans = null;

        *//* 长度为1时一定是回文串 *//*
        if(len == 1){
            return s;
        }
        for (int i = 0; i <= len-1; i++) {
            dp[i][i] = 1;
        }

        for (int j = 0; j <= len-1; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i) != s.charAt(j)){
                    dp[i][j] = 0;
                }
                else {
                    if(j-i > 2){
                        *//* 状态转移方程 *//*
                        dp[i][j] = dp[i+1][j-1];
                    }
                    *//* j-i <= 2，例如aba，aa这种情况肯定是回文串 *//*
                    else {
                        dp[i][j] = 1;
                    }
                }

                if((dp[i][j]==1) && (j-i+1 > maxlen)){
                    maxlen = j-i+1;
                    ans = s.substring(i, j+1);
                }
            }
        }
        return ans;
    }*/

    /**
     * @Description 2021.10.3号写的
     * @param
     * @return
     */
    public static String longestPalindrome(String s){
        int len = s.length();
        if(len == 1) return s;
        // dp[i][j]==0 表明s[i]到s[j]是回文串
        int[][] dp = new int[len][len];
        int max = 0;
        String res = s.charAt(0)+"";

        //初始化dp数组
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if(s.charAt(right) == s.charAt(left)){
                    if(right-left > 1){
                        dp[left][right] = dp[left+1][right-1];
                    }
                    else
                        dp[left][right] = 1;

                    if(dp[left][right]==1 && right-left+1>max){
                        max = right-left+1;
                        res = s.substring(left, right+1);
                    }
                }
                else 
                    dp[left][right] = 0;
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        String s = "babas";
        System.out.println(longestPalindrome(s));
    }
}
