import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    static List<List<Integer>> list;
    static boolean vis[];
    static long ret;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        vis = new boolean[n+1];
        ret = 0;
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }
        dfs(1, 1);
        System.out.println(ret);
    }

    public static void dfs(int node, int del) {
        if(node < del || ret == -1) {
            ret = -1;
            return;
        }
        ret += node - del;
        vis[node] = true;
        for(int child : list.get(node)){
            if(!vis[child]){
                dfs(child, node);
            }
        }
    }
}
