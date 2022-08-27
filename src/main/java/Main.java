import java.util.Arrays;
import java.util.Scanner;

/**
 * 最小生成树，Prime算法
 */
public class Main {

    static boolean[] visited;
    static int[] clo;
    static int[] low;
    public static int count(int n, int[] node1, int[] node2, int[] path){
        int[][] edge = new int[n+1][n+1];
        for (int i = 0; i < n+1; i++) {
            Arrays.fill(edge[i], 0);
        }
        for (int i = 0; i < node1.length; i++) {
            int n1 = node1[i];
            int n2 = node2[i];
            int cost = path[i];
            edge[n1][n2] = cost;
            edge[n2][n1] = cost;
        }

        visited = new boolean[n+1];
        low = new int[n+1];
        clo = new int[n+1];
        visited[1]  = true;
        for (int i = 1; i <= n; i++) {
            if(i == 1)
                low[i] = 0;
            else{
                low[i] = edge[1][i];
                clo[i] = 1;
                visited[i] = false;
            }
        }
        for (int i = 1; i < n; i++) {
            int temp = Integer.MAX_VALUE;
            int a = 1;
            for (int j = 1; j <= n; j++) {
                if(!visited[j] && low[j]<temp){
                    a = j;
                    temp = low[j];
                }
            }

            if(a == 1)
                break;
            visited[a] = true;
            for (int j = 1; j <= n; j++) {
                if(!visited[j] && edge[a][j] < low[j]){
                    low[j] = edge[a][j];
                    clo[j] = a;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += low[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] node1 = new int[m];
        int[] node2 = new int[m];
        int[] path = new int[m];
        for (int i = 0; i < m; i++) {
            node1[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            node2[i] = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < m; i++) {
            path[i] = sc.nextInt();
        }

        System.out.println(count(n, node1, node2, path));
    }
}



//3 3
//1 1 2
//2 3 3
//885 513 817
