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
        public String removeKdigits(String num, int k) {
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
        }
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;

        Solution solution = new Solution();
        System.out.println(solution.removeKdigits(num, k));
    }
}
