package LeetCode;

import java.sql.Struct;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/22 16:43
 */

public class Num200 {

    /*public static int numIslands(char[][] grid) {
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
    }*/

    //2022.03.13日写
    static class Solution {
        class Node{
            int x;
            int y;
            public Node(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        char[][] grid;
        int m;
        int n;
        //记录位置（x，y）是否已经被访问过
        boolean[][] visited;
        int[] x4 = new int[]{0,1,0,-1};
        int[] y4 = new int[]{-1,0,1,0};

        public int numIslands(char[][] grid) {
            this.grid = grid;
            m = grid.length;
            n = grid[0].length;
            //记录位置（x，y）是否已经被访问过
            visited = new boolean[m][n];
            // Arrays.fill 只能填充一维数组，多维数组还得用循环
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    visited[i][j] = false;
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j]=='1' && !visited[i][j]){
                        ans++;
                        BFS(i, j);
                    }
                }
            }
            return ans;
        }

        public boolean judge(int x, int y){
            if(x<0 || x>=m || y<0 || y>=n)
                return false;
            if(grid[x][y]=='0' || visited[x][y])
                return false;
            return true;
        }

        public void BFS(int x, int y){
            Queue<Node> queue = new ArrayDeque<>();
            queue.add( new Node(x,y) );
            while ( !queue.isEmpty() ){
                Node temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nowX = temp.x + x4[i];
                    int nowY = temp.y + y4[i];
                    if( judge(nowX, nowY) ){
                        Node node = new Node(nowX, nowY);
                        queue.add(node);
                        visited[nowX][nowY] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        Solution solution = new Solution();
        System.out.println( solution.numIslands(grid) );

    }
}
