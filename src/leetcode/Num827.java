package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/22 18:39
 */

public class Num827 {

    public static int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //count列表记录了每个岛屿的面积，
        List<Integer> count = AreaOfIsland(grid);
        int max = 0;
        for (int i = 0; i < count.size(); i++) {
            max = Math.max(max, count.get(i));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == 0){
                    max = Math.max(max, dfs1(grid, count, i, j));
                }
            }
        }
        return max;
    }

    public static int dfs1(int[][] grid, List<Integer> count, int i, int j){
        HashSet set = new HashSet();

        if(i+1 <= grid.length-1 && grid[i+1][j] != 0)
            set.add(grid[i+1][j]);
        if(j+1 <= grid[0].length-1 && grid[i][j+1] != 0)
            set.add(grid[i][j+1]);
        if(i-1 >= 0 && grid[i-1][j] != 0)
            set.add(grid[i-1][j]);
        if(j-1 >= 0 && grid[i][j-1] != 0)
            set.add(grid[i][j-1]);

        int temp = 0;
        for(Object k : set){
            temp += count.get(((int) k)-1);
        }
        return temp+1;

    }


    public static List<Integer> AreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //记录节点是否已经被遍历
        boolean[][] used = new boolean[m][n];
        //记录每个岛屿的面积
        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]==1 && !used[i][j]){
                    count.add(0);
                    //一次深度遍历就能确定一个岛屿的面积
                    dfs(grid, used, count, i, j);
                }

            }
        }

        return count;
    }

    public static void dfs(int[][] grid, boolean[][] used,List<Integer> count, int i, int j){
        used[i][j] = true;
        grid[i][j] = count.size();
        count.set(count.size()-1, count.get(count.size()-1)+1);

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
//        int[][] grid = new int[][]{{0, 1, 0, 1, 1},
//                                   {1, 1, 1, 0, 0},
//                                   {1, 1, 0, 0, 1},
//                                   {0, 1, 0, 0, 1}};
        int[][] grid = new int[][]{{1,1},{0,1}};
        System.out.println(largestIsland(grid));
    }
}
