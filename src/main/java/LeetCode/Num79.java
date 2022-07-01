package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:07 2022/7/1
 */
public class Num79 {
    static class Solution {
        static boolean res;
        static int[] x = new int[]{0,1,0,-1};
        static int[] y = new int[]{-1,0,1,0};
        public boolean exist(char[][] board, String word) {
            res = false;
            boolean[][] visit = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(res)
                        break;
                    if(board[i][j] == word.charAt(0)){
                        visit[i][j] = true;
                        dfs(i, j, board, word, 0, visit);
                        visit[i][j] = false;
                    }
                }
            }

            return res;
        }

        public boolean isVal(int tempX, int tempY, char[][] board){
            if(tempX<0 || tempY<0 || tempX>=board[0].length || tempY>=board.length)
                return false;
            return true;
        }

        public void dfs(int i, int j, char[][] board, String word, int index, boolean[][] visit){
            if(index == word.length()-1){
                res = true;
                return;
            }

            for (int k = 0; k < 4; k++) {
                int tempX = j + x[k];
                int tempY = i + y[k];
                if(isVal(tempX, tempY, board) && !visit[tempY][tempX] &&board[tempY][tempX]==word.charAt(index+1)){
                    visit[tempY][tempX] = true;
                    dfs(tempY, tempX, board, word, index+1, visit);
                    visit[tempY][tempX] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
