package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解：https://leetcode.cn/problems/remove-k-digits/solution/wei-tu-jie-dan-diao-zhan-dai-ma-jing-jian-402-yi-d/
 * @Data: Created in 19:01 2022/7/4
 */
public class Num402 {
    static class Solution {
        //单调栈
        /*public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            for(Character c : num.toCharArray()){
                // 维持一个递增的单调栈，去掉高位大的数字
                while (k>0 && !deque.isEmpty() && c<deque.peekLast()){
                    deque.removeLast();
                    k--;
                }
                // 删除前导0
                if(c!='0' || !deque.isEmpty())
                    deque.addLast(c);
            }

            // 若k个数字没删够，删掉低位，因为低位数字大
            while (k>0 && !deque.isEmpty()){
                deque.pollLast();
                k--;
            }

            StringBuffer buffer = new StringBuffer();
            while(!deque.isEmpty()){
                buffer.append(deque.pollFirst());
            }

            return buffer.length() == 0 ? "0" : buffer.toString();
        }*/

        // 2020.07.24写
        public String removeKdigits(String num, int k) {
            // 维持一个单调递增的栈
            // 遍历num，如果当前字符比前一个字符小，就把前一个字符去除，整个num就会变小
            Deque<Character> deque = new ArrayDeque<>();
            for(Character c : num.toCharArray()){
                while (k>0 && !deque.isEmpty() && c < deque.peekLast()){
                    deque.removeLast();
                    k--;
                }

                // 如果c不是0，可以加入栈
                // 如果c是0，但栈不为空，可以加入
                // 如果c是0且栈为空，前导0，
                if(c!='0' || !deque.isEmpty())
                    deque.addLast(c);
            }

            while (k>0 && !deque.isEmpty()){
                deque.removeLast();
                k--;
            }

            StringBuilder builder = new StringBuilder();
            int len = deque.size();
            for (int i = 0; i < len; i++) {
                builder.append(deque.removeFirst());
            }
            return builder.toString();
        }
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }
}
