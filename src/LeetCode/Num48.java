package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:01 2022/1/3
 */
public class Num48 {

    static class Solution {
        //解法1，暴力解，时间复杂度和空间复杂度都是0(n*2)
        /*public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] repulication = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    repulication[j][n-i-1] = matrix[i][j];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = repulication[i][j];
                }
            }
        }*/

        public void rotate(int[][] matrix){

        }
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("----原数组----");
        for(int[] num : nums){
            for(int i : num){
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Solution solution = new Solution();
        solution.rotate(nums);

        System.out.println("\n" + "----翻转后的数组----");
        for(int[] num : nums){
            for(int i : num){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
