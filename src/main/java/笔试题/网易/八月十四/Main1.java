package 笔试题.网易.八月十四;

import java.util.Scanner;

public class Main1 {

    static boolean[] visited;
    public static void dfs(String s, String[] ss){
        if("".equals(s))
            return;
        String[] split = s.split(",");

        for(String s1 : split){
            int temp = Integer.parseInt(s1);
            if(visited[temp])
                continue;
            visited[temp] = true;
            dfs(ss[temp], ss);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder builder = new StringBuilder(s);
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length()-1);
        String s1 = builder.toString();
        String[] ss = s1.split("]");
        for (int i = 0; i < ss.length; i++) {
            String[] sss = ss[i].split(",");
            StringBuilder builder1 = new StringBuilder();

            for (int j = 0; j < sss.length; j++) {
                String s2 = sss[j];
                for (int k = 0; k < s2.length(); k++) {
                    if(s2.charAt(k) >= '0' && s2.charAt(k)<='9'){
                        builder1.append(s2.charAt(k));
                    }
                }
                if(j != sss.length-1)
                    builder1.append(",");
            }
            if(builder1.length()>0 && builder1.charAt(0)==',')
                builder1.deleteCharAt(0);
            ss[i] = builder1.toString();
        }

        visited = new boolean[ss.length];
        visited[0] = true;
        dfs(ss[0], ss);
        boolean flag = true;
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("true");
        else
            System.out.println("false");

    }
}

// [[1,3],[3,0,1],[2],[0]]