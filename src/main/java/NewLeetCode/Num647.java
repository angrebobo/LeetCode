package NewLeetCode;

/**
 * 回文子串
 */
public class Num647 {

    /**
     * 三层遍历
     */
    public static int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        boolean flag;
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j <= length; j++) {
                flag = true;
                for (int k = i; k < j; k++) {
                    if(s.charAt(k) != s.charAt(j-1-k+i)){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 动态规划
     * dp[i][j] 表示从i到j的字符串是否是回文串
     * 状态转移方程：
     * 当s[i] == s[j]时，dp[i][j] = dp[i+1][j-1]
     * 当s[i] != s[j]时，dp[i][j] = false
     *
     * 有个很巧妙的点，外层循环从j开始遍历，这样可以保证dp[i+1][j-1]已经被计算过了
     */
    public static int countSubstrings1(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];
        int count = 0;
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                if(s.charAt(i)==s.charAt(j) && (j-i<=2 || dp[i+1][j-1]==1)){
                    dp[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings1(s));
    }
}
