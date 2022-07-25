package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:40 2022/7/25
 */
public class Num316 {
    static class Solution {
        // 2020.07.25写
        // map记录每个字符的出现次数
        // 维护一个单调栈。遍历字符串，如果当前字符比前一个字符小，移除前一个字符。因为把大的字符从高位去除，整体字典序会变小
        // 如果当前字符串已经在栈里了，不做处理
        public String removeDuplicateLetters(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(Character c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            Deque<Character> deque = new ArrayDeque<>();
            Character temp;
            for(Character c : s.toCharArray()){
                if(!deque.contains(c)){
                    while(!deque.isEmpty() && c < (temp=deque.peekLast()) &&
                            map.get(temp)>1){
                        map.put(temp, map.get(temp)-1);
                        deque.removeLast();
                    }

                    deque.addLast(c);
                }
                else
                    map.put(c, map.get(c)-1);
            }

            StringBuilder builder = new StringBuilder();
            int len = deque.size();
            for(int i = 0; i < len; i++)
                builder.append(deque.pollFirst());

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters("bbcaac"));
    }
}
