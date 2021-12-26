import java.util.ArrayList;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/22 18:19
 */

public class Num695 {

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //记录节点是否已经被遍历
        boolean[][] used = new boolean[m][n];
        //记录每个岛屿的面积
        List<Integer> count = new ArrayList<>();
        int max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1 && !used[i][j]){
                    count.clear();
                    //一次深度遍历就能确定一个岛屿的面积
                    dfs(grid, used, count, i, j);
                    max = Math.max(count.size(), max);
                }
            }
        }

        return max;
    }

    public static void dfs(int[][] grid, boolean[][] used,List<Integer> count, int i, int j){
        used[i][j] = true;
        count.add(1);

        //往下遍历
        if(i+1 <= grid.length-1 && grid[i+1][j] == 1 && !used[i+1][j])
            dfs(grid, used, count,i+1, j);
        //往右遍历
        if(j+1 <= grid[0].length-1 && grid[i][j+1] == 1 && !used[i][j+1])
            dfs(grid, used, count, i, j+1);
        //往上遍历
        if(i-1 >= 0 && grid[i-1][j] == 1 && !used[i-1][j])
            dfs(grid, used, count,i-1, j);
        //往左遍历
        if(j-1 >= 0 && grid[i][j-1] == 1 && !used[i][j-1])
            dfs(grid, used,count, i, j-1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(maxAreaOfIsland(grid));
    }
}
