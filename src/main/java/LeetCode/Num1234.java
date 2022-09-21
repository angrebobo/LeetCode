/*
package LeetCode;

import javax.print.DocFlavor;
import java.util.HashMap;

*/
/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 16:35 2022/9/20
 *//*

public class Num1234 {
    static class Solution {
        public int balancedString(String s) {
            int len = s.length();
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c-'A'] += 1;
            }

            int[] need = new int[26];
            if(count['Q'-'A'] > len/4){
                need['Q'-'A'] = count['Q'-'A'] - len/4;
            }
            if(count['W'-'A'] > len/4){
                need['W'-'A'] = count['W'-'A'] - len/4;
            }
            if(count['E'-'A'] > len/4){
                need['E'-'A'] = count['E'-'A'] - len/4;
            }
            if(count['R'-'A'] > len/4){
                need['R'-'A'] = count['R'-'A'] - len/4;
            }

            // 原字符串已经平衡了
            if(check(need))
                return 0;

            int maxStart=0, maxEnd=0, maxLen=0;
            int left=0, right=0;
            while (right < len){
                // 让right一直往右移动
                while(!check(need) && right<len){
                    Character c = s.charAt(right);
                    if (need[c-'A']>0)
                        need[c-'A'] -= 1;
                    right++;
                }

                // 让left往右移动
                while (left<right){
                    Character c = s.charAt(left);
                    if(count[c-'A']>0){
                        if(right-left+1 > maxLen){
                            maxLen = right-left+1;
                            maxStart = left;
                            maxEnd = right;
                        }
                    }
                }

            }




        }

        public boolean check(int[] need){
            return need['Q' - 'A'] == 0 && need['W' - 'A'] == 0 && need['E' - 'A'] == 0 && need['R' - 'A'] == 0;
        }
    }

    public static void main(String[] args) {
        String s ="QQWE";
        Solution solution = new Solution();
        System.out.println(solution.balancedString(s));
    }
}
*/
