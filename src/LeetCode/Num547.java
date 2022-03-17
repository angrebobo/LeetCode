package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:52 2022/3/17
 */
public class Num547 {

    //题解1，深度优先搜索
    static class Solution {
        boolean[] visited;
        int num = 0;
        int len;
        public int findCircleNum(int[][] isConnected) {
            len = isConnected.length;
            visited = new boolean[len];
            for (int i = 0; i < len; i++) {
                visited[i] = false;
            }

            for (int i = 0; i < len; i++) {
                //如果该城市还未被访问，去DFS中递归访问与该城市连结的城市
                if(!visited[i]){
                    DFS(isConnected, i);
                    num++;
                }
            }

            return num;
        }

        public void DFS(int[][] isConnected,int i){
            for (int j = 0; j < len; j++) {
                if(isConnected[i][j]==1 && !visited[j]){
                    visited[j] = true;
                    DFS(isConnected, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1,0,0},
                               {0,1,0},
                               {0,0,1}};

        Solution solution = new Solution();
        System.out.println(solution.findCircleNum(isConnected));
    }
}
