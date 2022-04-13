package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description: 拓扑排序
 * @Data: Created in 14:37 2022/4/13
 */
public class Num207 {
    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            //G邻接表
            List<List<Integer>> G = new ArrayList<>();
            //inDegree记录每个节点的入度
            int[] inDegree = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            int num = 0;

            //初始化
            for (int i = 0; i < numCourses; i++) {
                G.add(new ArrayList<>());
            }
            for(int[] cp : prerequisites){
                G.get(cp[1]).add(cp[0]);
                inDegree[cp[0]]++;
            }
            for (int i = 0; i < numCourses; i++) {
                if(inDegree[i] == 0)
                    queue.add(i);
            }

            while ( !queue.isEmpty() ){
                int node = queue.poll();
                for(Integer node_after : G.get(node)){
                    inDegree[node_after]--;
                    if(inDegree[node_after] == 0)
                        queue.add(node_after);
                }
                num++;
            }

            return num == numCourses;
        }
    }

    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{1,0},{0,1},{0,2}};

        Solution solution = new Solution();
        System.out.println(solution.canFinish(numCourses, prerequisites));
    }
}
