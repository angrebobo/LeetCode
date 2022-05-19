package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:30 2022/5/17
 */
public class Offer_Num38 {
    static class Solution {
        public String[] permutation(String s) {
            int len = s.length();
            char[] nums = s.toCharArray();
            int[] visited = new int[len];
            List<Character> path = new LinkedList<>();
            List<List<Character>> list = new LinkedList<>();

            //先对nums排序
            Arrays.sort(nums);
            backTrace(nums, visited, path, list);

            String[] ans = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                StringBuilder temp = new StringBuilder();
                for(Character character : list.get(i)){
                    temp.append(character);
                }
                ans[i] = temp.toString();
            }


            return ans;
        }

        public void backTrace(char[] nums, int[] visited, List<Character> path, List<List<Character>> list){
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
        String s = "abc";
        Solution solution = new Solution();
        System.out.println(solution.permutation(s).toString());
    }
}
