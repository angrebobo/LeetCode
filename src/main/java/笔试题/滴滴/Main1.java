package 笔试题.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:32 2022/9/4
 */
public class Main1 {

    static int maxCount = -1;
    public static void dfs(long[] weights, int index,
                           int count, List<Long> path, int k){
        if(path.size() > 0){
            long max = 0;
            long sum = 0;
            for (Long integer : path) {
                max = Math.max(max, integer);
                sum += integer;
            }
            double temp = (double) sum / (double)path.size() * (double)k;
            if((double)max > temp)
                return;
        }

        maxCount = Math.max(maxCount, count);

        if(index == weights.length)
            return;

        path.add(weights[index]);
        dfs(weights, index+1, count+1, path, k);
        path.remove(path.size()-1);

        dfs(weights, index+1, count, path, k);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] weights = new long[n];
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextLong();
        }
        dfs(weights, 0, 0, new ArrayList<>(), k);
        System.out.println(maxCount);
    }
}
