package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:48 2022/4/22
 */
public class Num47 {

    static class Solution {

        //方法1，求出所有结果然后去重
        //该方法性能不好，对列表去重需要排序后一个个比对
        /*public List<List<Integer>> permuteUnique(int[] nums) {
            int[] visited = new int[nums.length];
            List<Integer> path = new LinkedList<>();

            Set<List<Integer>> set = new HashSet<>();
            backTrace(nums, visited, path, set);

            return new LinkedList<>(set);
        }

        public void backTrace(int[] nums, int[] visited, List<Integer> path, Set<List<Integer>> set){
            int len = nums.length;

            if(path.size() == len){
                set.add(new LinkedList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if(visited[i] == 1)
                    continue;

                path.add(nums[i]);
                visited[i] = 1;
                backTrace(nums, visited, path, set);
                visited[i] = 0;
                path.remove(path.size()-1);
            }
        }*/

        // 方法2，剪枝
        public List<List<Integer>> permuteUnique(int[] nums) {
            int[] visited = new int[nums.length];
            List<Integer> path = new LinkedList<>();
            List<List<Integer>> list = new LinkedList<>();

            //先对nums排序
            Arrays.sort(nums);
            backTrace(nums, visited, path, list);

            return list;
        }

        public void backTrace(int[] nums, int[] visited, List<Integer> path, List<List<Integer>> list){
            int len = nums.length;

            if(path.size() == len){
                list.add(new LinkedList<>(path));
                return;
            }

            for (int i = 0; i < len; i++) {
                if(visited[i] == 1)
                    continue;

                //前面节点和现节点值相同，而且前面节点未访问，那如果继续深搜现节点，结果一定是重复的
                if(i > 0 && nums[i]==nums[i-1] && visited[i-1]==0)
                    continue;

                path.add(nums[i]);
                visited[i] = 1;
                backTrace(nums, visited, path, list);
                visited[i] = 0;
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,3};
        Solution solution = new Solution();
        List<List<Integer>> ans = solution.permuteUnique(nums);

        System.out.println(ans.toString());
    }
}
