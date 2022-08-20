package 笔试题.网易.八月二十;

import java.util.Scanner;

public class Main1 {

    static int ans;
    public static int count(StringBuilder a, StringBuilder b){
        ans = Integer.MAX_VALUE;
        dfs(a, b, 0, 0, 0);
        return ans;
    }

    public static void dfs(StringBuilder a, StringBuilder b, int index1, int index2, int num){
        int A = Integer.parseInt(a.toString());
        int B = Integer.parseInt(b.toString());
        if(A%B==0 || B%A==0){
            ans = Math.min(ans, num);
        }
        if(index1>a.length() && index2>b.length())
            return;

        dfs(a ,b ,index1, index2, num);

        char temp = a.charAt(index1);
        a.deleteCharAt(index1);
        dfs(a, b, index1+1, index2, num+1);
        a.insert(index1, temp);

        char temp1 = b.charAt(index2);
        b.deleteCharAt(index2);
        dfs(a, b, index1, index2+1, num+1);
        b.insert(index2, temp1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        StringBuilder A = new StringBuilder(a+"");
        StringBuilder B = new StringBuilder(b+"");
        System.out.println(count(A, B));
    }
}
