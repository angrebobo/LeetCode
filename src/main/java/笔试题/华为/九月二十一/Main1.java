package 笔试题.华为.九月二十一;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:36 2022/9/21
 */
public class Main1 {

    static int min;
    static HashMap<String, int[]> map = new HashMap<>();

    public static int calculate(int m, int n, char[][] graph){
        min = Integer.MAX_VALUE;
        int[] I1 = new int[]{-1, 0, 1, 0};
        int[] J1 = new int[]{0, 1, 0, -1};
        int[] I2 = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int[] J2 = new int[]{1, 2, 2, 1,-1, -2, -2, -1};
        map.put("I1", I1);
        map.put("J1", J1);
        map.put("I2", I2);
        map.put("J2", J2);
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        dfs(0, 0, 1, graph, 0, visited);
        return min;
    }

    public static void dfs(int startI, int startJ, int version, char[][] graph, int cur, boolean[][] visited){
        // 到达终点
        if(startI==graph.length-1 && startJ==graph[0].length-1){
            min = Math.min(min, cur);
            return;
        }
        if(cur > min)
            return;

        String nameI = "I"+version;
        String nameJ = "J"+version;
        int[] I = map.get(nameI);
        int[] J = map.get(nameJ);
        for (int i = 0; i < I.length; i++) {
            int nextI = startI + I[i];
            int nextJ = startJ + J[i];
            if(check(graph, nextI, nextJ, visited)){
                visited[nextI][nextJ] = true;
                dfs(nextI, nextJ, version, graph, cur+1, visited);
                visited[nextI][nextJ] = false;
            }
        }

        // 变化状态
        if(graph[startI][startJ]=='S'){
            version = version==1? 2 : 1;
            dfs(startI, startJ, version, graph, cur+1, visited);
        }
    }

    public static boolean check(char[][] graph, int nextI, int nextJ, boolean[][] visited){
        return nextI >= 0 && nextI < graph.length && nextJ >= 0 && nextJ < graph[0].length
                && graph[nextI][nextJ] != 'X' && !visited[nextI][nextJ];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        char[][] graph = new char[m][n];
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            graph[i] = s.toCharArray();
        }
        System.out.println(calculate(m, n, graph));
    }
}

//9 9
//.........
//.....XXX.
//.....X.X.
//.....X.X.
//.....X.XS
//XXXXXX.XX
//.........
//.........
//.........
//
//输出:15