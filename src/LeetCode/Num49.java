package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/24 23:38
 **/
public class Num49 {
    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String s : strs){
                char[] chars = s.toCharArray();
                Arrays.sort(chars);
                if(map.getOrDefault(String.valueOf(chars), null) == null){
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    map.put(String.valueOf(chars), list);
                }
                else {
                    List<String> list = map.get(String.valueOf(chars));
                    list.add(s);
                    map.put(String.valueOf(chars), list);
                }
            }

            List<List<String>> lists = new ArrayList<>();
            for (String key : map.keySet()){
                lists.add( map.get(key) );
            }
            return lists;
        }
    }

    public static void main(String[] args) {
        String[] s1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] s2 = new String[]{""};
        String[] s3 = new String[]{"a"};

        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(s3));

    }
}
