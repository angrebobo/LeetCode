package 笔试题.华为.八月三十一;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目: 士兵的任务2
 * 题目描述:士兵在迷宫中执行任务，迷宫中危机重重，他需要在在最短的时间内到达指定的终点。你可以告诉士兵他最少需要多长时间吗?
 * 输入一个n*m的迷宫中，迷宫中0为路，1为墙，2为起点，3为终点，4为陷阱，6为炸弹。
 * 士兵只能向上下左右四个方向移动，如果路径上为墙，不能移动。
 * 已知每走一步需要花费1个单位的时间，走到陷阱上需要花费3个单位的时间，走到炸弹上将会激活炸弹将炸弹上下左右的墙炸为路。
 *
 * 注意点:
 * 炸弹只能炸掉墙，不会炸掉陷阱
 * 炸弹、陷阱只能发挥一次作用
 * 迷言为最大为25*25
 * 用例保证士兵一定有方法能到达终点
 * 输入描述:第一行:n和m 第二行开始:n*m的矩阵
 * 4 4
 * 1 1 1 1
 * 1 6 2 1
 * 1 1 0 1
 * 1 3 1 1
 *
 * 输出描述
 * 最少需要的单位时间
 * 3
 * 解释：
 * 士兵在位置2，向左移动到炸弹上，会将炸弹周围的墙炸掉，向下走两步 即可到达终点
 *
 * 输入:
 * 4 4
 * 1 1 1 1
 * 1 0 2 0
 * 1 6 1 4
 * 1 3 1 1
 * 输出：3
 *
 * 输入：
 * 4 4
 * 1 6 0 2
 * 0 4 1 1
 * 0 4 0 3
 * 1 0 1 1
 * 输出：10
 *
 *
 * @Data: Created in 14:14 2022/9/12
 */
public class Main2 {


    static int ans;
    static int[] I = new int[]{1, 0, -1, 0};
    static int[] J = new int[]{0, -1, 0, 1};

    public static void dfs(int[][] graph, int curI, int curJ, int count,
                           boolean[][] visited, int endI, int endJ){
        // 到达终点
        if(curI==endI && curJ==endJ){
            ans = Math.min(ans, count);
            return;
        }
        if(count > ans)
            return;


        for (int i = 0; i < 4; i++) {
            int nextI = curI + I[i];
            int nextJ = curJ + J[i];
            if(check(graph, nextI, nextJ)){
                // 路，陷阱已访问过，炸弹已访问过
                if(graph[nextI][nextJ] == 0 || graph[nextI][nextJ] == 3 || graph[nextI][nextJ] == 4&&visited[nextI][nextJ]
                || graph[nextI][nextJ] == 6&&visited[nextI][nextJ]){
                    dfs(graph, nextI, nextJ, count+1, visited, endI, endJ);
                }
                else if(graph[nextI][nextJ] == 4 && !visited[nextI][nextJ]){
                    visited[nextI][nextJ] = true;
                    dfs(graph, nextI, nextJ, count+3, visited, endI, endJ);
                    visited[nextI][nextJ] = false;
                }
                else if(graph[nextI][nextJ] == 6 && !visited[nextI][nextJ]){
                    // isChanged用来记录 上右下左 被炸掉的墙
                    boolean[] isChanged = new boolean[4];
                    for (int j = 0; j < 4; j++) {
                        int changeX = nextI + I[j];
                        int changeY = nextJ + J[j];
                        if(check(graph, changeX, changeY) && graph[changeX][changeY]==1){
                            graph[changeX][changeY] = 0;
                            isChanged[j] = true;
                        }
                    }
                    visited[nextI][nextJ] = true;

                    dfs(graph, nextI, nextJ, count+1, visited, endI, endJ);

                    // 把墙复原
                    for (int j = 0; j < 4 && isChanged[j]; j++) {
                        graph[nextI + I[j]][nextJ + J[j]] = 1;
                        isChanged[j] = false;
                    }
                    visited[nextI][nextJ] = false;
                }
            }
        }
    }

    // 判断位置是否越界
    public static boolean check(int[][] graph, int nextI, int nextJ){
        return nextI >= 0 && nextI <= graph.length - 1 && nextJ >= 0 && nextJ <= graph[0].length - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ans = m*n;
        int[][] graph = new int[n][m];
        int startI = 0;
        int startJ = 0;
        int endI = 0;
        int endJ = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                graph[i][j] = sc.nextInt();
                if(graph[i][j] == 2){
                    startI = i;
                    startJ = j;
                }
                else if(graph[i][j] == 3){
                    endI = i;
                    endJ = j;
                }
            }
            sc.nextLine();
        }

        boolean[][] visited = new boolean[n][m];
        dfs(graph, startI, startJ, 0, visited, endI, endJ);
        System.out.println(ans);
    }
}
