package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/search-a-2d-matrix/
 * @Data: Created in 23:21 2022/3/4
 */
public class Num74 {
    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int pos = -1;
            //先判断target位于数组哪一行
            for (int i = 0; i < m; i++) {
                if(target >= matrix[i][0])
                    pos = i;
            }
            if(pos == -1) return false;

            //再用二分搜索查找target
            int left = 0;
            int right = n-1;
            while (left <= right){
                int mid = left+(right-left)/2;
                if(matrix[pos][mid] == target)
                    return true;
                else if(matrix[pos][mid] < target){
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 9;

        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(matrix, target));
    }
}
