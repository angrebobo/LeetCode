package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目链接：https://leetcode-cn.com/problems/combination-sum/
 * 这题和零钱兑换那题很像
 */
public class Num39 {

    /*static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            Deque<Integer> path = new LinkedList<>();
            List<List<Integer>> ans = new ArrayList<>();
            if(target < candidates.length)
                return ans;
            Arrays.sort(candidates);
            backTrace(candidates, target, 0,path, ans);
            return ans;
        }

        // 怎么保证结果不重复的呢？
        // 看这篇题解https://leetcode.cn/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
        // target减去a后，就不要再去减比a小的数了
        public void backTrace(int[] candidates, int target, int index, Deque<Integer> path,
                              List<List<Integer>> ans){

            if(target == 0){
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                int num = candidates[i];
                // 剪枝，前提是数组是有序的
                if(target - num < 0)
                    break;

                path.addLast(num);
                // 这里的i是关键
                backTrace(candidates, target-num, i, path, ans);
                path.removeLast();
            }
        }
    }*/

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            Arrays.sort(candidates);
            dfs(candidates, 0, target, path, ans);
            return ans;
        }

        public void dfs(int[] candidates, int index, int target, List<Integer> path,
                        List<List<Integer>> ans){

            if(target == 0){
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if(target-candidates[i] < 0)
                    break;

                path.add(candidates[i]);
                dfs(candidates, i, target-candidates[i], path, ans);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
    int[] candidates = new int[]{2,3,6,7};
    int target = 7;
    Solution solution = new Solution();
    System.out.println(solution.combinationSum(candidates, target));
    }
}
