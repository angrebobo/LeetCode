package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:10 2022/8/7
 */
public class Num344 {
    static class Solution {
        public void reverseString(char[] s) {
            int len = s.length;
            for (int i = 0; i < len/2; i++) {
                char temp = s[len-1-i];
                s[len-1-i] = s[i];
                s[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(s);
    }
}
