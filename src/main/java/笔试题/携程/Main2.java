package 笔试题.携程;

import java.util.Scanner;

public class Main2 {

    public static int calculate(int a, int b, int c){
        int ans = 0;
        int n = Math.min(a, Math.min(b,c));
        ans += 2*n;
        b -= n;
        if(b >= 2)
            ans += b-1;

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            System.out.println(calculate(a,b,c));
            sc.nextLine();

        }
    }
}
