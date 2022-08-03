package LeetCode;

import java.util.Arrays;

public class Main1 {

    public static int[] findBuilding (int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] += back(heights, i);
            res[i] += go(heights, i);
            res[i] += 1;
        }

        return res;
    }

    public static int back(int[] heights, int index){
        if(index > 0){
            int count = 0;
            int max = 0;
            for (int i = index-1; i >= 0; i--) {
                if(i == index-1){
                    count++;
                    max = Math.max(max, heights[i]);
                }
                else {
                    if(heights[i] > max){
                        count++;
                        max = Math.max(max, heights[i]);
                    }
                }
            }
            return count;
        }
        else
            return 0;
    }

    public static int go(int[] heights, int index){
        if(index < heights.length-1){
            int count = 0;
            int max = 0;
            for (int i = index+1; i < heights.length; i++) {
                if(i == index+1){
                    count++;
                    max = Math.max(max, heights[i]);
                }
                else {
                    if(heights[i] > max){
                        count++;
                        max = Math.max(max, heights[i]);
                    }
                }
            }
            return count;
        }
        else
            return 0;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{50, 30, 80, 30, 27, 57};
        System.out.println(Arrays.toString(findBuilding(nums)));
    }
}
