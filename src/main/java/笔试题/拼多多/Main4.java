package 笔试题.拼多多;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:31 2022/9/25
 */
public class Main4 {
    static List<Integer> ans = new ArrayList<>();
    public static void dfs(int cur, int n, int m, int[] cats, int[][] road,
                           boolean[] visited, List<Integer> path){

        if(path.size() > ans.size()){
            ans = new ArrayList<>(path);
        }
        else if(path.size() == ans.size()){
            int sum1 = 0;
            for (Integer integer : ans) {
                sum1 += cats[integer];
            }
            int sum2 = 0;
            for (Integer integer : path) {
                sum2 += cats[integer];
            }
            if(sum2<sum1){
                ans = new ArrayList<>(path);
            }
        }

        for (int i = 1; i <= n; i++) {
            if(road[cur][i]==1 && !visited[i] && m>=cats[i]){
                visited[i] = true;
                path.add(i);
                dfs(i, n, m-cats[i], cats, road, visited, path);
                visited[i] = false;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] cats = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cats[i] = sc.nextInt();
        }
        int[][] road = new int[n+1][n+1];
        for (int i = 0; i < n-1; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            road[x][y] = road[y][x] = 1;
        }
        boolean[] visited = new boolean[n+1];
        if(cats[1]>m)
            System.out.print(0 +" " + 0);
        else {
            visited[1] = true;
            List<Integer> path = new ArrayList<>();
            path.add(1);
            dfs(1,n,m-cats[1],cats,road,visited, path);
//            int MaxSum = 0;
//            for (int i = 0; i < ans.size(); i++) {
//                if(i==0){
//                    int sum = 0;
//                    for (Integer integer : ans.get(0)) {
//                        sum+=cats[integer];
//                    }
//                    MaxSum = sum;
//                }
//                else {
//                    if(ans.get(i).size()==ans.get(i-1).size()){
//                        int sum = 0;
//                        for (Integer integer : ans.get(i)) {
//                            sum+=cats[integer];
//                        }
//                        MaxSum = Math.min(sum, MaxSum);
//                    }
//                    else
//                        break;
//                }
//            }
            int sum = 0;
            for (Integer integer : ans) {
                sum+=cats[integer];
            }
            System.out.println(ans.size() + " " + sum);
        }
    }
}
