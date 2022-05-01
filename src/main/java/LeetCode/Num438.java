package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description: https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * @Data: Created in 22:43 2022/3/11
 */
public class Num438 {

    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            //滑动窗口的大小
            int size = p.length();
            int len = s.length();
            List<Integer> list = new LinkedList<>();

            if(s.length() < size) return new LinkedList<>();

            for (int i = 0; i < len; i++) {
                if(i + size > len)
                    break;
                String temp = s.substring(i, i + size);
                if( isAnagrams(temp, p) )
                    list.add(i);
            }
            return list;
        }

        boolean isAnagrams(String s, String p){
            int[] sCount = new int[26];
            int[] pCount = new int[26];
            int len = s.length();
            for (int i = 0; i < len; i++) {
                sCount[s.charAt(i) - 'a']++;
                pCount[p.charAt(i) - 'a']++;
            }

            return Arrays.equals(sCount, pCount);
        }
    }

    public static void main(String[] args) {
        String s = "abbab";
        String p = "abb";

        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s, p));
    }
}
