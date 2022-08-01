package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：https://codeantenna.com/a/Qeba4CWBLV
 * 不同形状的岛屿的数量
 * 思路：把岛屿的相对坐标记下来，因为bfs或者dfs遍历的方向都是一样的，所以如果岛屿相同，相对坐标也是相同的
 * @Data: Created in 13:55 2022/8/1
 */
public class Num694 {

    static class Solution {
        public int numDistinctIslands(int[][] grid) {
            Set<String> islands = new HashSet<>();
            int rows = grid.length;
            if (rows == 0) return 0;
            int cols = grid[0].length;
            if (cols == 0) return 0;
            // 遍历坐标为 1 的点
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        StringBuilder islandCoordinate = new StringBuilder();
                        dfs(grid, islandCoordinate, i, j, i, j);
                        islands.add(islandCoordinate.toString());
                    }
                }
            }
            return islands.size();
        }

        private void dfs(int[][] grid, StringBuilder islandCoordinate,
                         int curX, int curY,
                         int originX, int originY) {
            if (curX < 0 || curX >= grid.length || curY < 0 || curY >= grid[0].length || grid[curX][curY] == 0) {
                return;
            }
            grid[curX][curY] = 0; // 表示当前坐标已经处理，后面不要重复计算它
            islandCoordinate.append(curX - originX);  // 记录相对横坐标
            islandCoordinate.append(curY - originY);  // 记录相对纵坐标
            dfs(grid, islandCoordinate, curX - 1, curY, originX, originY);    // 上
            dfs(grid, islandCoordinate, curX + 1, curY, originX, originY);    // 下
            dfs(grid, islandCoordinate, curX, curY - 1, originX, originY);    // 左
            dfs(grid, islandCoordinate, curX, curY + 1, originX, originY);    // 右
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1,0,0,0,0},
                {1,1,0,0,0},
                {0,0,0,0,1},
                {0,0,0,1,1}
        };
        
        Solution solution = new Solution();
        System.out.println(solution.numDistinctIslands(grid));
    }
}
