package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:21 2022/5/28
 */
public class Num240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int r = matrix.length;
            if(r == 0)
                return false;
            int c =matrix[0].length;
            if(c == 0)
                return false;
            for(int i = r-1; i >= 0; i--){
                if(target < matrix[i][0])
                    continue;
                for(int j = 0; j < c; j++){
                    if(target == matrix[i][j]){
                        return true;
                    }
                    if(target < matrix[i][j])
                        break;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
