package 笔试题.网易.八月十四;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            if(s.startsWith("25")){
                count++;
                continue;
            }
            if(s.endsWith("25")){
                count++;
                continue;
            }
            if(s.contains("25"))
                count++;
        }
        System.out.println(count);
    }
}
