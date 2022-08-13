package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 9:55 2021/5/26
 */
public class Num54 {
    /*public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> path = new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] used = new boolean[m][n];
        int i =0, j=0;
        while (true){
            if(!used[i][j]){
                mock(matrix, i, j, path, used);
            }
            else
                break;

            if(i+1>=m || j+1>=n)
                break;
            else {
                i++;
                j++;
            }
        }
        return path;
    }

    //添加一圈的数据
    public static void mock(int[][] matrix, int i, int j, List<Integer> path, boolean[][] used){
        //设置上下左右四个边界点
        int top = i;
        int bottom = i+1;
        int left = j;
        int right = j;


        for (; right<=matrix[0].length-1; right++) {
            if(used[i][right]==true)
                break;

            used[i][right] = true;
            path.add(matrix[i][right]);
        }
        right--;

        for (; bottom<=matrix.length-1; bottom++) {
            if(used[bottom][right]==true)
                break;

            used[bottom][right] = true;
            path.add(matrix[bottom][right]);
        }
        bottom--;

        for (int k = right-1; k>=j; k--) {
            if(used[bottom][k]==true)
                break;

            used[bottom][k] = true;
            path.add(matrix[bottom][k]);
        }

        for (int m = bottom-1; m>=i; m--) {
            if(used[m][j]==true)
                break;

            used[m][j] = true;
            path.add(matrix[m][j]);
        }
    }*/

    /*public static List<Integer> spiralOrder(int[][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 0) return new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        //设置上下左右四个边界点
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while (true){
            for (int i = left; i <= right; i++)
                path.add(matrix[top][i]);
            if(++top > bottom) break;

            for (int i = top; i <= bottom; i++)
                path.add(matrix[i][right]);
            if(--right < left) break;

            for (int i = right; i >= left; i--)
                path.add(matrix[bottom][i]);
            if(--bottom < top) break;

            for (int i = bottom; i >= top; i--)
                path.add(matrix[i][left]);
            if(++left > right) break;
        }
        return path;
    }*/

    // 2022.08.12写
    public static int[] spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row*col];
        int top = 0, left = 0, right = col-1, bottom = row-1;
        int index = 0;
        while(top<=bottom && left<=right){
            for(int j=left; j<=right; j++){
                res[index++] = matrix[top][j];
            }
            if(++top>bottom) break;
            for(int i=top; i<=bottom; i++){
                res[index++] = matrix[i][right];
            }
            if(--right<left) break;
            for(int j=right; j>=left; j--){
                res[index++] = matrix[bottom][j];
            }
            if(--bottom<left) break;
            for(int i=bottom; i>=top; i--){
                res[index++] = matrix[i][left];
            }
            if(++left>right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9,10,11,12}};
        System.out.println(Arrays.toString(spiralOrder(matrix)));
    }
}
