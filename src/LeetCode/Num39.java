package LeetCode;

import java.util.*;

/**
 * 题目链接：https://leetcode-cn.com/problems/combination-sum/
 * 这题和零钱兑换那题很像
 */
public class Num39 {

    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            //使用Set集合可以去重
            List<Set<List<Integer>>> dp = new ArrayList<>();
            int len = candidates.length;
            dp.add(null);

            //主要思想是dp，把每个数的组合都记录下来
            for (int i = 1; i <= target; i++) {
                Set<List<Integer>> temp = new HashSet<>();
                for (int j = 0; j < len; j++) {
                    //相等时，就直接加入集合。比如目标数5，可以由5组成
                    if (candidates[j] == i) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        temp.add(list);
                    }
                    //目标数大于数组整数时，比如6>2,就去检查2和4是否有组合
                    else if (candidates[j] < i && dp.get(candidates[j]) != null && dp.get(i - candidates[j]) != null) {
                        List<Integer> temp1;
                        List<Integer> temp2;
                        for (List<Integer> list : dp.get(candidates[j])) {
                            for (List<Integer> list1 : dp.get(i - candidates[j])) {
                                temp1 = new ArrayList<>(list);
                                temp2 = new ArrayList<>(list1);
                                temp1.addAll(temp2);
                                temp1.sort((o1, o2) -> o1 - o2);
                                temp.add(temp1);
                            }
                        }
                    }
                }
                if (temp.size() == 0) dp.add(null);
                else dp.add(temp);
            }
            if (dp.get(target) == null) return new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>(dp.get(target));
            return res;
        }
    }

    public static void main(String[] args) {
    int[] candidates = new int[]{1,2,5};
    int target = 11;
    Solution solution = new Solution();
    System.out.println(solution.combinationSum(candidates, target));
    }
}
