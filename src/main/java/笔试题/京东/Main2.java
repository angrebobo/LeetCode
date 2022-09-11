package 笔试题.京东;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：子串必须连续
 * 题目描述：定义一个括号串的权值为，它的最长合法括号子序列的长度。
 * 例如，"())())的权值是4，它的最长合法括号子序列为"()()”
 * 现在求一个给定括号串的所有子串权值之和。
 * 输入描述：一个仅包含'('和')'的字符串，长度不超过2e5。
 * (()())
 * 输出描述：所有子串的权值和。
 * 26
 * @Data: Created in 19:30 2022/9/3
 */
public class Main2 {

    // https://www.acwing.com/solution/content/82621/
    public static int count(String s){
        int left = 0;
        int right = 0;
        // 就是在统计合法的有括号有多少个
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                left++;
            // 如果left<=0，就说明当下这个右括号非法
            else if(left > 0){
                left--;
                right++;
            }
        }
        right *= 2;
        return right;
    }

    // O(n*3)的复杂度，只能过18%
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {
                ans += count( s.substring(i, j) );
            }
        }
        System.out.println(ans);
    }
}
