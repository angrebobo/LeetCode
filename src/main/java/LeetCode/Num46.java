package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/18 22:23
 */

public class Num46 {

    public static List<List<Integer>> permute(int[] nums) {
        int depth = 0;
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        if(len == 0) return res;
        boolean[] used = new boolean[len];
        /*dfs(nums, depth, len, used, path, res);*/
        backTrace(nums, used, path, res);
        return res;
    }

    // 解法1，
    public static void dfs(int[] nums, int depth, int len, boolean[] used,
                           List<Integer> path, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth+1, len, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }


    //解法2，和解法1其实一样，更容易理解
    public static void backTrace(int[] nums, boolean[] visited, List<Integer> path, List<List<Integer>> res){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if( visited[i] ) continue;
            visited[i] = true;
            path.add(nums[i]);
            backTrace(nums, visited, path, res);
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);
    }
}
