package 笔试题.字节.九月十八;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:25 2022/9/18
 */
public class Main33 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int max = 0;
        for (int i = 0; i < len; i++) {
            int temp = 1;
            int j;
            for (j = i; j+1<len && s.charAt(j)!=s.charAt(j+1); j++) {
            }
            temp = j-i+1;
            if(temp>=3)
                max = Math.max(temp, max);
        }
        System.out.println(max);
    }
}
