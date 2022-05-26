package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:17 2022/5/11
 */
public class Num51 {
    static class Solution {
        public List<List<String>> solveNQueens(int n) {
            List<List<String>> res = new LinkedList<>();
            //record记录皇后的位置，record[i]表示第i个皇后放在第record[i]列
            int[] record = new int[n];
            List<String> path = new LinkedList<>();
            backTrace(0, record, n, res, path);

            return res;
        }

        public void backTrace(int i, int[] record, int n, List<List<String>> res, List<String> path){
            if(i == n)
                res.add(new LinkedList<>(path));

            for (int j = 0; j < n; j++) {
                if( isValid(i, j, record) ){
                    record[i] = j;

                    path.add( process(j, n) );
                    backTrace(i+1, record, n, res, path);
                    path.remove(path.size()-1);
                }
            }
        }

        //按照题目格式要求打印
        public String process(int j, int n){
            StringBuffer buffer = new StringBuffer();
            for (int k = 0; k < n; k++) {
                if(k == j)
                    buffer.append("Q");
                else
                    buffer.append(".");
            }

            return buffer.toString();
        }

        /**
         * 检测在第i行第j列放置皇后，是否会和已放置的皇后同列同斜线
         */
        public boolean isValid(int i, int j, int[] record){
            for (int k = 0; k < i; k++) {
                if(j == record[k] || Math.abs(k-i)==Math.abs(record[k]-j))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> res = solution.solveNQueens(4);
        System.out.println(res.toString());
    }
}
