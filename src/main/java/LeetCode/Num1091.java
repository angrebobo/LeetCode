package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/27 13:09
 **/
public class Num1091 {
    static class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            Queue<int[]> queue = new ArrayDeque<>();
            int m = grid.length;

            if(grid[0][0]==1 || grid[m-1][m-1]==1)
                return -1;

            queue.add( new int[]{0,0} );
            int[][] mem = new int[m][m];
            mem[0][0]=1;
            int max = 0;

            while ( !queue.isEmpty() ){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] node = queue.peek();
                    int x = node[0];
                    int y = node[1];

                    if(x==m-1 && y==m-1)
                        return max+1;

                    int[][] nextNodes= new int[][]{{x-1,y-1},{x,y-1},{x+1,y-1},{x-1,y},
                                                   {x+1,y},{x-1,y+1},{x,y+1},{x+1,y+1}};
                    for(int[] nextNode : nextNodes){
                        if(nextNode[0]<0 || nextNode[0]>=m || nextNode[1]<0 || nextNode[1]>=m)
                            continue;
                        if(grid[nextNode[0]][nextNode[1]] == 1)
                            continue;
                        if(mem[nextNode[0]][nextNode[1]] == 1)
                            continue;

                        queue.add(nextNode);
                        mem[nextNode[0]][nextNode[1]] = 1;
                    }
                    queue.poll();
                }
                max++;
            }

            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1}};
        Solution solution = new Solution();
        System.out.println(solution.shortestPathBinaryMatrix(grid));
    }
}
