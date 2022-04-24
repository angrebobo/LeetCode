package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/leetbook/read/illustration-of-algorithm/58wowd/
 * @Data: Created in 12:56 2022/4/24
 */
public class Offer_Num12 {
    static class Solution {
        static boolean flag;
        static int[] opeartion_row = new int[]{-1, 0, 1, 0};
        static int[] opeartion_col = new int[]{0, 1, 0, -1};

        public boolean exist(char[][] board, String word) {
            flag = false;
            //先找到起始点的位置,起始点可能有多个
            int row_len = board.length;
            int col_len = board[0].length;
            boolean[][] visited = new boolean[row_len][col_len];
            for (int i = 0; i < row_len; i++) {
                for (int j = 0; j < col_len; j++) {
                    if(board[i][j] == word.charAt(0)){
                        for(boolean[] temp : visited)
                            Arrays.fill(temp, false);

                        visited[i][j] = true;
                        dfs(board, word, 0, i, j, visited);
                    }
                }
            }

            return flag;
        }

        public void dfs(char[][] board, String word, int index, int row, int col, boolean[][] visited){
            //已经找到一条路，直接return
            if(flag)
                return;
            if(index == word.length()-1){
                flag = true;
                return;
            }

            List<Integer> list1 = new LinkedList<>();
            List<Integer> list2 = new LinkedList<>();
            //计算不越界，没有被访问过的上下左右位置
            for (int i = 0; i < 4; i++) {
                int tempRow = row + opeartion_row[i];
                int tempCol = col + opeartion_col[i];
                if(tempRow<0 || tempRow>=board.length || tempCol<0 || tempCol>=board[0].length)
                    continue;
                if(visited[tempRow][tempCol])
                    continue;

                list1.add(tempRow);
                list2.add(tempCol);
            }

            for (int i = 0; i < list1.size(); i++) {
                if(board[list1.get(i)][list2.get(i)] == word.charAt(index+1)){
                    visited[list1.get(i)][list2.get(i)] = true;
                    dfs(board, word, index+1, list1.get(i), list2.get(i), visited);
                    //状态回归
                    visited[list1.get(i)][list2.get(i)] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        /*char[][] board = new char[][]{{'A','B','C','E'},
                                      {'S','F','C','S'},
                                      {'A','D','E','E'}};
        String word = "ABCCED";*/
        char[][] board = new char[][]{{'A','B','C','E'},
                                      {'S','F','E','S'},
                                      {'A','D','E','E'}};
        String word = "ABCEFSADEESE";
        Solution solution = new Solution();
        System.out.println(solution.exist(board, word));
    }
}
