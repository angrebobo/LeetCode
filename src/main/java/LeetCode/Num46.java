package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @desiption: 全排列，回溯
 * @author: HuangSiBo
 * @data: 2021/5/18 22:23
 */

public class Num46 {

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if(len == 0) return res;
        boolean[] used = new boolean[len];
        backTrace(nums, used, path, res);
        return res;
    }

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
        int[] nums = new int[]{1,2,3};
        List<List<Integer>> ans = permute(nums);
        System.out.println(ans);

        StringBuilder builder = new StringBuilder();
    }
}
