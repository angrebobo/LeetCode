package LeetCode;

import org.checkerframework.checker.units.qual.A;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 18:50 2022/5/19
 */
public class Offer_Num48 {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            if(len == 0)
                return 0;
            int left = 0;
            int right = 0;
            int max = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            while (right < len){
                char c = s.charAt(right);
                if( map.containsKey(c) )
                    left = Math.max(left, map.get(c)+1);

                map.put(c, right);
                max = Math.max(max, right-left+1);
                right++;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        String s = " ";
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
