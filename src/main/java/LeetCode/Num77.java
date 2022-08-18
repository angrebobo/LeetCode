package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:49 2022/8/13
 */
public class Num77 {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> ans = new ArrayList<>();
            if(k<=0 || n<k)
                return ans;

            dfs(n, 1, new ArrayDeque<>(), ans, k);
            return ans;
        }

        public void dfs(int n, int index, Deque<Integer> path, List<List<Integer>> ans, int k){
            if(path.size() == k){
                ans.add(new ArrayList<>(path));
                return;
            }

            for (int i = index; i <= n; i++) {
                //取当前数
                path.addLast(i);
                dfs(n, i+1, path, ans, k);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Solution solution = new Solution();
        System.out.println(solution.combine(n, k).toString());
    }
}
