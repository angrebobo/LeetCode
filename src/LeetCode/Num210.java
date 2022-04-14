package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:40 2022/4/14
 */
public class Num210 {

    static class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            //G邻接表
            List<List<Integer>> G = new ArrayList<>();
            //inDegree记录每个节点的入度
            int[] inDegree = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            int num = 0;
            List<Integer> list = new LinkedList<>();

            //初始化
            for (int i = 0; i < numCourses; i++) {
                G.add(new ArrayList<>());
            }
            for(int[] cp : prerequisites){
                G.get(cp[1]).add(cp[0]);
                inDegree[cp[0]]++;
            }
            for (int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0){
                    queue.add(i);
                    list.add(i);
                }
            }

            while ( !queue.isEmpty() ){
                int node = queue.poll();
                for(Integer node_after : G.get(node)){
                    inDegree[node_after]--;
                    if(inDegree[node_after] == 0){
                        queue.add(node_after);
                        list.add(node_after);
                    }

                }
                num++;
            }

            if(num == numCourses){
                int[] ans = new int[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    ans[i] = list.get(i);
                }
                return ans;
            }
            else
             return new int[0];
        }
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{1,0},{1,2}};

        Solution solution = new Solution();
        int[] ans = solution.findOrder(numCourses, prerequisites);
        for(int i : ans)
            System.out.println(i);
    }
}
