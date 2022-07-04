package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:01 2022/7/4
 */
public class Num402 {
    static class Solution {
        public String removeKdigits(String num, int k) {
            Deque<Character> deque = new LinkedList<>();
            for(Character c : num.toCharArray()){
                while (k>0 && !deque.isEmpty() && c<deque.peekLast()){
                    deque.removeLast();
                    k--;
                }
                if(c!='0' || !deque.isEmpty())
                    deque.addLast(c);
            }

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
