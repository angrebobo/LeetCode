package LeetCode;

import java.util.Arrays;

public class Offer_Num74 {

    static class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
            int len = intervals.length;
            int[][] res = new int[len][2];
            int index = -1;
            for (int i = 0; i < len; i++) {
                if(i == 0 || intervals[i][0]>res[index][1])
                    res[++index] = intervals[i];
                else
                    res[index][1] = Math.max(res[index][1], intervals[i][1]);
            }
            return Arrays.copyOf(res, index+1);
        }

        /*public static int[][] merge(int[][] intervals) {
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
        }*/
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(nums)));
    }
}
