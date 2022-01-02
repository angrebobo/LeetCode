package leetcode;

import java.util.HashMap;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/4/17 12:24
 */

public class Num3 {

    //解法1，暴力解法，复杂度是O（n2）
//    public static int lengthOfLongestSubstring(String s) {
//        int len = s.length();
//        if(len == 0)
//            return 0;
//        int[] dp = new int[len];
//
//        for (int i = 0; i < len; i++) {
//            dp[i] = 1;
//        }
//        int max = 1;
//
//        for (int i = 1; i < len; i++) {
//            int count = 1;
//            for (int j = 1; j <= dp[i-1] ; j++) {
//                if(s.charAt(i) != s.charAt(i-j)){
//                    count++;
//                }
//                else
//                    break;
//                dp[i] = count;
//            }
//            if(dp[i] > max) {
//                max = dp[i];
//            }
//        }
//
//        return max;
//    }

    //解法2,用map中的下标来模拟滑动窗口
    /*public static int lengthOfLongestSubstring(String s){
        int len = s.length();
        if(len == 0)
            return 0;

        int start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max_len = 0;

        for (int end = 0; end < len; end++) {
            Character c = s.charAt(end);

            if( map.containsKey(c) )
                start = Math.max(map.get(c)+1, start);

            map.put(c, end);
            max_len = Math.max(end - start + 1, max_len);
        }

        return max_len;
    }*/











    static class Solution {
        public static int lengthOfLongestSubstring( String s){
            if(s.length() == 0) return 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            int len;
            int left = 0;
            int right = 0;

            while (left <= right && right < s.length()){
                Character c = s.charAt(right);

                if( map.containsKey(c) )
                    left = Math.max(map.get(c)+1, left);

                map.put(c, right);
                len = right - left + 1;
                max = Math.max(max, len);
                right++;
            }

            return max;
        }
    }



    public static void main(String[] args) {
        String s = "abba";

        System.out.println(Solution.lengthOfLongestSubstring(s));
//        System.out.println(lengthOfLongestSubstring(s));
    }
}
