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

        //方法2，原地修改
        // 题解：https://leetcode.cn/problems/rotate-image/solution/li-kou-48xiao-bai-du-neng-kan-dong-de-fang-fa-zhu-/
        public void rotate(int[][] matrix){
            int x = 0;
            int y = matrix.length-1;
            int add = 0;
            // 坐标系为向下x轴，向右y轴
            // 四个点的初试位置分别为(x, x),(x, y),(y, y),(y,x)
            // 变换后的位置为(x, x+add),(x+add, y),(y, y-add),(y-add,x)
            while (x <= y) {
                for (add = 0; add < y - x; add++) {
                    int temp = matrix[y - add][x];
                    matrix[y - add][x] = matrix[y][y - add];
                    matrix[y][y - add] = matrix[x + add][y];
                    matrix[x + add][y] = matrix[x][x + add];
                    matrix[x][x + add] = temp;
                }
                x++;
                y--;
            }
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
