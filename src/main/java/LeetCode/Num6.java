package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:46 2022/7/21
 */
public class Num6 {
    static class Solution {
        // 方法1，二维数组模拟
        /*public String convert(String s, int numRows) {
            if(numRows == 1) return s;
            int len = s.length();
            char[][] nums = new char[numRows][len];
            for (int i = 0; i < numRows; i++) {
                Arrays.fill(nums[i], ' ');
            }
            int row = 0;
            int col = 0;
            int count = 1;
            for(int i = 0; i < len; i++){
                nums[row][col] = s.charAt(i);
                if(count%(numRows*2-2) > (numRows*2-2)/2 || count%(numRows*2-2) == 0){
                    row--;
                    col++;
                }
                else{
                    row++;
                }
                count++;
            }

            StringBuffer buffer = new StringBuffer();
            for(int i = 0; i < numRows; i++){
                for(int j = 0; j < len; j++){
                    if(nums[i][j] != ' ')
                        buffer.append( nums[i][j] );
                }
            }
            return buffer.toString();
        }*/

        // 方法2
        // 题解：https://leetcode.cn/problems/zigzag-conversion/solution/zzi-xing-bian-huan-by-jyd/
        public String convert(String s, int numRows) {
            if(numRows < 2) return s;
            List<StringBuffer> list = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                list.add(new StringBuffer());
            }
            int flag = -1;
            int i = 0;
            for(char c : s.toCharArray()){
                list.get(i).append(c);

                if(i == 0 || i == numRows-1)
                    flag = -flag;
                i += flag;
            }
            for (int j = 1; j < numRows; j++) {
                list.get(0).append( list.get(j) );
            }

            return list.get(0).toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int num = 4;
        System.out.println(solution.convert(s, num));
    }
}
