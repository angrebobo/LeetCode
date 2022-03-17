package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:52 2022/3/17
 */
public class Num547 {
    static class Solution {
        boolean[][] visited;
        int num = 0;
        public int findCircleNum(int[][] isConnected) {
            int len = isConnected.length;
            visited = new boolean[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    visited[i][j] = false;
                }
            }

            for (int i = 0; i < len; i++) {
                for (int j = i+1; j < len; j++) {
                    if(isConnected[i][j] == 1 && !visited[i][j]){
                        DFS(isConnected, i ,j);
                        num++;
                    }
                }
            }

            return num;
        }

        public void DFS(int[][] isConnected, int i, int j){

        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,1,0},
                               {1,1,0},
                               {0,0,1}};

        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(isConnected));
    }
}
