package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:36 2022/6/26
 */
public class Num221 {

    static class Solution {
        public int maximalSquare(char[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            // dp[i][j] 以 matrix[i][j] 为右下角的正方形的最大边长
            int[][] dp = new int[m+1][n+1];
            int res = 0;
            // 初始化dp,这两个for循环不写也没关系，int数组默认值就是0
            for (int i = 0; i < n+1; i++) {
                dp[0][i] = 0;
            }
            for (int i = 0; i < m+1; i++) {
                dp[i][0] = 0;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(matrix[i][j] == '1'){
                        dp[i+1][j+1] = minVal(dp[i][j+1], dp[i][j], dp[i+1][j]) + 1;
                        res = Math.max(res, dp[i+1][j+1]);
                    }
                }
            }

            return res*res;
        }

        public int minVal(int a, int b, int c){
            int temp = Math.min(a, b);
            return Math.min(temp, c);
        }
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(matrix));
//        System.out.println(solution.minVal(3, 2, 2));
    }
}
