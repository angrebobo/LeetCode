package LeetCode;

import java.util.Arrays;

public class Num1235 {

    static class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int len = startTime.length;
            //将任务按照结束时间排序
            int[][] arr = new int[len][3];
            for (int i = 0; i < len; i++) {
                int[] temp = new int[]{startTime[i], endTime[i], profit[i]};
                arr[i] = temp;
            }

            Arrays.sort(arr, (o1,o2)->o1[1]-o2[1]);


            //prev[i]的值为，如果做i任务，之前能做的最近的任务编号
            int[] prev = new int[len];
            prev[0] = -1;
            for (int i = 1; i < len; i++) {
                prev[i] = findPrev(arr, i);
            }

            int[] dp = new int[len];
            dp[0] = arr[0][2];
            int max = dp[0];
            for (int i = 1; i < len; i++) {
                int temp = (prev[i]==-1)?(arr[i][2]):(arr[i][2]+dp[prev[i]]);
                dp[i] = Math.max(dp[i-1], temp);
                max = Math.max(max, dp[i]);
            }
            return max;
        }


        public int findPrev(int[][] arr, int index){
            int left = 0;
            int right = index-1;
            while (left < right){
                int mid = (left+right+1)/2;
                if(arr[mid][1] > arr[index][0])
                    right = mid-1;
                else
                    left = mid;
            }
            if(left<index && arr[left][1]<=arr[index][0])
                return left;
            else return -1;
        }
    }

    public static void main(String[] args) {
        int[] startTime = new int[]{1,2,3,4,6};
        int[] endTime = new int[]{3,5,10,6,9};
        int[] profit = new int[]{20,20,100,70,60};
        Solution solution = new Solution();
        System.out.println(solution.jobScheduling(startTime, endTime, profit));
    }
}
