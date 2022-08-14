package 笔试题.大疆.八月十四;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目：假设我们有一批任务需要调度执行， 每个任务j(j=0,1...n-1)拥有一个权重wj，我们的目标是调度权重累加和最大
 * 的的任务子集执行。已知任务到达的时刻为sj，终止的时刻为fj (注意，这里fj为任务结束的时刻，而不是执行时长)。
 * 只有当两个任务的执行时间区间没有重叠的情况下， 这两个任务才能被调度先后执行，否则只能选其中之一调度执行。
 *
 * 编写一个函数schedule，输入一个包含n个任务信息的数组 (列表) [wj sj fj], j=0,1...n-1(0,1...n-1为任务
 * 索引)，例如，在下面示例中，任务0的信息为[3 0 6]， 其中3为该任务的权重，0为任务到达时刻， 6为任务终
 * 止时刻。返回可调度的最优任务子集(即： 该任务子集权重和最大)所对应的任务索引 (输出的任务索引按升序
 * 排列)。为简化输出结果测试，假设最优解只有一组 (测试用例中不会出现多组最优解的情况)。
 * 注：如果任务1为[10 2 5],任务2为[9 5 7], 则任务1和任务2的执行时间区间没有重叠； 如果任务1为[10 2 5],
 * 务2为[9 4 7], 则任务1和任务2的执行时间区间有重叠。
 *
 * 输入：
 * 8个任务，每个任务3个参数
 * 然后8行
 * 8 3
 * 3 0 6
 * 1 1 4
 * 4 3 5
 * 17 3 8
 * 9 4 7
 * 10 5 9
 * 8 6 10
 * 1 8 11
 *
 * 输出：
 * 3 7
 */
public class Main {

    static int maxVal;
    static List<Integer> ans;
    public static void dfs(int[][] map, int index, boolean[] visited, int val, List<Integer> path){
        if(index == map.length){
            if(val>maxVal){
                maxVal = val;
                ans = new ArrayList<>(path);
            }
            return;
        }


        int v = map[index][0];
        boolean flag = true;
        //先检查时间是否重叠,两端不用检查
        for (int i = map[index][1]+1; i < map[index][2]; i++) {
            if(visited[i]){
                flag = false;
                break;
            }
        }
        if(flag){
            //选当前任务
            for (int i = map[index][1]; i <= map[index][2]; i++) {
                visited[i] = true;
            }
            path.add(index);
            dfs(map, index+1, visited, val+v, path);
            for (int i = map[index][1]; i <= map[index][2]; i++) {
                visited[i] = false;
            }
            path.remove(path.size()-1);
        }


        //不选当前任务
        dfs(map, index+1, visited, val, path);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[][] map = new int[n][3];
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            int start = sc.nextInt();
            int end = sc.nextInt();
            map[i][0] = val;
            map[i][1] = start;
            map[i][2] = end;

            min = Math.min(min, start);
            max = Math.max(max, end);
        }

        maxVal = 0;
        ans = new ArrayList<>();
        boolean[] visited = new boolean[max+1];
        dfs(map, 0, visited, 0, new ArrayList<>());
        for (Integer an : ans) {
            System.out.print(an + " ");
        }
    }
}



