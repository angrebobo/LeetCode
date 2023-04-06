package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num40 {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            dfs(candidates, target, 0, path, ans);
            return ans;
        }


        public void dfs(int[] candidates, int target, int index,
                        List<Integer> path, List<List<Integer>> ans){

            if(target==0){
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i < candidates.length; i++) {
                if(target-candidates[i]<0)
                    return;
                // 去重
                if(i>index && candidates[i-1]==candidates[i])
                    continue;

                path.add(candidates[i]);
                dfs(candidates, target-candidates[i], i+1, path, ans);
                path.remove(path.size()-1);
            }
        }
    }


    public static void main(String[] args) {
        int[] candidates = new int[]{2,5,2,1,2};
        int target = 5;
        Solution solution = new Solution();
        System.out.println(solution.combinationSum2(candidates, target));
    }
}
