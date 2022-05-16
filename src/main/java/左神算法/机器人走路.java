package 左神算法;

import com.sun.javafx.robot.FXRobotImage;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * 假设有排成一行的N个位置，记为1~N,N一定大于或等于2
 * 开始时机器人在其中的M位置上(M一定是1~N中的一个)
 * 如果机器人来到1位置，那么下一步只能往右来到2 位置；
 * 如果机器人来到N位置，那么下一步只能往左来到N-1 位置：
 * 如果机器人来到中间位置，那么下一步可以往左走或者往右走；
 * 规定机器人必须走K步，最终能来到P位置(P也是1~N中的一个)的方法有多少种
 * 给定四个参数N、M、K、P,返回方法数。
 * @Data: Created in 11:03 2022/5/16
 */
public class 机器人走路 {
    static List<List<Integer>> list = new LinkedList<>();
    static int count = 0;

    public static void walk(int N, int M, int K, int P){
        if(N < 2 || P < 1 || P > N)
            return;

//        List<Integer> path = new LinkedList<>();
//        path.add(M);
//        dfsPath(N, M, K, P, path);

//        long startTime=System.currentTimeMillis();
//        dfsCount(N, M, K, P);
//        System.out.println("dfsCount ans: " + count);
//        long endTime=System.currentTimeMillis();
//        System.out.println("dfsCount花费的时间： " + (endTime-startTime) + "ms");

        cache = new int[N+1][K+1];
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < K+1; j++) {
                cache[i][j] = -1;
            }
        }
        long startTime2=System.currentTimeMillis();
        System.out.println("dfsCache ans: " + dfsCache(N, M, K, P));
        long endTime2=System.currentTimeMillis();
        System.out.println("dfsCache花费的时间： " + (endTime2-startTime2) + "ms");

        long startTime1=System.currentTimeMillis();
        System.out.println("dfsCount1 ans: " + dfsCount1(N, M, K, P));
        long endTime1=System.currentTimeMillis();
        System.out.println("dfsCount1花费的时间： " + (endTime1-startTime1) + "ms");
    }

    /**
     * 计算机器人到达终点走过的路径
     */
    public static void dfsPath(int N, int M, int K, int P, List<Integer> path){
        if(M < 1 || M > N || K < 0)
            return;
        if(M == P && K == 0){
            list.add( new LinkedList<>(path) );
            return;
        }

        //往左走
        path.add(M-1);
        dfsPath(N, M-1, K-1, P, path);
        path.remove(path.size()-1);

        //往右走
        path.add(M+1);
        dfsPath(N, M+1, K-1, P, path);
        path.remove(path.size()-1);
    }

    /**
     * 方法1
     * 机器人能到达终点的路径数
     */
    public static void dfsCount (int N, int M, int K, int P){
        if(M < 1 || M > N || K < 0)
            return;
        if(M == P && K == 0){
            count++;
            return;
        }

        //往左走
        dfsCount(N, M-1, K-1, P);

        //往右走
        dfsCount(N, M+1, K-1, P);
    }

    /**
     * 方法2
     * 计算机器人能到达终点的路径。
     */
    public static int dfsCount1(int N, int M, int K, int P){
        if(K == 0)
            return M==P ? 1 : 0;

        if(M == 1)
            return dfsCount1(N, 2, K-1, P);
        if(M == N)
            return dfsCount1(N, N-1, K-1, P);

        return dfsCount1(N, M-1, K-1, P) + dfsCount1(N, M+1, K-1, P);
    }

    /**
     * 设计一个缓存，避免递归过程中大量的重复计算
     * 计算机器人能到达终点的路径
     */
    static int[][] cache;
    public static int dfsCache(int N, int M, int K, int P){
        if(cache[M][K] != -1)
            return cache[M][K];

        if(K == 0){
            cache[M][K] = (M==P ? 1 : 0);
            return cache[M][K];
        }

        if(M == 1){
            cache[M][K] = dfsCount1(N, 2, K-1, P);
            return cache[M][K];
        }
        if(M == N){
            cache[M][K] = dfsCount1(N, N-1, K-1, P);
            return cache[M][K];
        }

        cache[M][K] = dfsCount1(N, M-1, K-1, P) + dfsCount1(N, M+1, K-1, P);
        return cache[M][K];
    }


    public static void main(String[] args) {
        int N = 20;
        int M = 2;
        int P = 19;
        int K = 33;
        walk(N, M, K, P);

//        System.out.println( list.toString() );
    }
}
