package leetcode;

import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/22 16:43
 */

public class Num200 {

    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //记录节点是否已经被遍历
        boolean[][] used = new boolean[m][n];
        int num = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1' && !used[i][j]){
                    num++;
                    dfs(grid, used, i, j);
                }
            }
        }

        return num;
    }

    public static void dfs(char[][] grid, boolean[][] used, int i, int j){
        used[i][j] = true;

        //往下遍历
        if(i+1 <= grid.length-1 && grid[i+1][j] == '1' && !used[i+1][j])
            dfs(grid, used, i+1, j);
        //往右遍历
        if(j+1 <= grid[0].length-1 && grid[i][j+1] == '1' && !used[i][j+1])
            dfs(grid, used, i, j+1);
        //往上遍历
        if(i-1 >= 0 && grid[i-1][j] == '1' && !used[i-1][j])
            dfs(grid, used, i-1, j);
        //往左遍历
        if(j-1 >= 0 && grid[i][j-1] == '1' && !used[i][j-1])
            dfs(grid, used, i, j-1);
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '0', '1','1','1'},
                {'1', '0', '1','0','1'},
                {'1', '1', '1','0','1'},
            };
        System.out.println(numIslands(grid));

    }
}
