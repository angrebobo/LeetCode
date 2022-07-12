package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 13:19 2022/7/12
 */
public class Num59 {
    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] res = new int[n][n];
            int top=0, bottom=n-1, left=0, right=n-1;
            int num=1;
            while(left<=right && top<=bottom){
                for(int i=left;i<=right;i++)
                    res[top][i] = num++;
                top++;
                for(int i=top;i<=bottom;i++)
                    res[i][right] = num++;
                right--;
                for(int i=right;i>=left;i--)
                    res[bottom][i] = num++;
                bottom--;
                for(int i=bottom;i>=top;i--)
                    res[i][left] = num++;
                left++;
            }

            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
    }
}
