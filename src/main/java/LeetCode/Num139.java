package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Num139 {
    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            HashMap<Integer, Boolean> map = new HashMap<>();

            return dfs(s, wordDict, 0, map);
        }

        public boolean dfs(String s, List<String> wordDict, int index, HashMap<Integer, Boolean> map){
            if(index == s.length())
                return true;
            if(map.containsKey(index))
                return map.get(index);

            for (int i = 0; i+index < s.length(); i++) {
                if(wordDict.contains(s.substring(index, index+i+1)) && dfs(s, wordDict, index+i+1, map)){
                    map.put(index, true);
                    return true;
                }
            }

            map.put(index, false);
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "catssand";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");


        Solution solution = new Solution();
        System.out.println(solution.wordBreak(s, wordDict));
    }
}
