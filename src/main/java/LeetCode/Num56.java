package LeetCode;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 23:57 2021/7/18
 */
public class Num56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v0,v1)->v0[0]-v1[0]);

        int len = intervals.length;
        int[][] ans = new int[len][2];
        int index = -1;
        for (int[] interval : intervals) {
            if(index==-1 || interval[0]>ans[index][1]){
                ans[++index] = interval;
            }
            else {
                ans[index][1] = Math.max(ans[index][1], interval[1]);
            }
        }
        return Arrays.copyOf(ans, index+1);
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ans = merge(intervals);
        for(int[] a : ans){
            System.out.println(a[0] + " " + a[1]);
        }
    }
}
