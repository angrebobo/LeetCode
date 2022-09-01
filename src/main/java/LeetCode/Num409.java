package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:47 2022/9/1
 */
public class Num409 {
    static class Solution {
        public int longestPalindrome(String s) {
            int[] count = new int[128];
            for (char c : s.toCharArray()) {
               count[c-'A']++;
            }

            int ans = 0;
            boolean flag = false;
            for (int i : count) {
                if(i % 2 == 0)
                    ans += i;
                else {
                    flag = true;
                    ans += i-1;
                }
            }

            return flag?(++ans):(ans);
        }
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));
    }
}
