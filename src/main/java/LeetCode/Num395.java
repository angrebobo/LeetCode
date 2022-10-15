package LeetCode;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * @Data: Created in 17:44 2022/5/30
 */
public class Num395 {
    /*static class Solution {

        // 分治思想
        public int longestSubstring(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(Character c : s.toCharArray()){
                map.put(c, map.getOrDefault(c,0)+1);
            }
            int res = 0;
            for (Character character : map.keySet()) {
                if(map.get(character) < k){
                    for (String s1 : s.split(character+"")) {
                        res = Math.max(res, longestSubstring(s1, k));
                    }
                    return res;
                }
            }

            // 若当前字符串符合要求，直接返回长度
            return s.length();
        }
    }*/

    static class Solution {
        public int longestSubstring(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c,0)+1);
            }
            int res = 0;

            for (char c : map.keySet()) {
                if(map.get(c) < k){
                    for (String s1 : s.split(c + "")) {
                        res = Math.max(res, longestSubstring(s1, k));
                    }
                    return res;
                }
            }

            return s.length();
        }
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.longestSubstring(s, k));
    }
}
