package 笔试题.京东;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:30 2022/9/3
 */
public class Main2 {

    public static int count(String s){
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(')
                left++;
            else if(left > 0){
                left--;
                right++;
            }
        }
        right *= 2;
        return right;
    }

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
