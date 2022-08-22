package 笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:45 2022/8/18
 */
public class Main {

    public static void dfs(int m, int n, int index, int len,
                    StringBuilder builder, List<String> list){

        if(index == len){
            if(check(builder.toString())){
                list.add(builder.toString());
            }
            return;
        }
        if(m<0)
            return;
        if(n<0)
            return;


        builder.append('m');
        dfs(m-1, n, index+1, len, builder, list);
        builder.deleteCharAt(builder.length()-1);


        builder.append('n');
        dfs(m, n-1, index+1, len, builder, list);
        builder.deleteCharAt(builder.length()-1);
    }

    public static boolean check(String s){
        int c = 3;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'm')
                c *= 2;
            else if(s.charAt(i) == 'n')
                c--;
            if(i!=s.length()-1 && c==0){
                return false;
            }
        }

        return c == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        List<String> list = new ArrayList<>();
        dfs(m, n, 0, m+n, new StringBuilder(), list);
        System.out.println(list.size());
//        System.out.println(check("mnnnnnnm"));
    }
}
