package LeetCode;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/25 10:55
 **/
public class Num455 {

    static class Solution {
        //方法1，运行时间95ms
        /*public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int[] used = new int[s.length];
            Arrays.fill(used, 0);
            int count = 0;

            for (int i = 0; i < g.length; i++) {
                for (int j = 0; j < s.length; j++) {
                    if(g[i] <= s[j] && used[j]==0){
                        used[j] = 1;
                        count++;
                        break;
                    }
                }
            }

            return count;
        }*/

        //方法2，运行时间7ms
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);

            int childCount = 0;
            int cookieCount = 0;
            while (childCount < g.length && cookieCount < s.length){
                if(g[childCount] <= s[cookieCount]){
                    childCount++;
                }
                cookieCount++;
            }
            return childCount;
        }
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,3,5};
        int[] s = new int[]{1,2};

        Solution solution = new Solution();
        System.out.println( solution.findContentChildren(g,s) );
    }
}


