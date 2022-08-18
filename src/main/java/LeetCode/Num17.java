package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:40 2022/8/18
 */
public class Num17 {
    /*static class Solution {
        static HashMap<Integer, List<Character>> map = new HashMap<>();

        static {
            map.put(2, Arrays.asList('a','b','c'));
            map.put(3, Arrays.asList('d','e','f'));
            map.put(4, Arrays.asList('g','h','i'));
            map.put(5, Arrays.asList('j','k','l'));
            map.put(6, Arrays.asList('m','n','o'));
            map.put(7, Arrays.asList('p','q','r', 's'));
            map.put(8, Arrays.asList('t','u','v'));
            map.put(9, Arrays.asList('w','x','y','z'));
        }

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if("".equals(digits))
                return ans;
            backTrace(digits, 0, "", ans);
            return ans;
        }

        public void backTrace(String digits, int index, String path,List<String> ans){
            if(index == digits.length()){
                ans.add(path);
                return;
            }

            int n = digits.charAt(index)-'0';
            List<Character> characters = map.get(n);

            for (int i = 0; i < characters.size(); i++) {
                backTrace(digits, index+1, path+characters.get(i), ans);
            }
        }
    }*/

    // 方法2，回溯，用String数组替代hashmap，用StringBuilder代替String，性能好了很多
    static class Solution {
        String[] call = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> ans = new ArrayList<>();
            if("".equals(digits) || digits.length()==0)
                return ans;
            backTrace(digits, 0, new StringBuilder(), ans);
            return ans;
        }

        public void backTrace(String digits, int index, StringBuilder path,List<String> ans){
            if(index == digits.length()){
                ans.add(path.toString());
                return;
            }

            int n = digits.charAt(index)-'0';
            int len = call[n].length();

            for (int i = 0; i < len; i++) {
                path.append(call[n].charAt(i));
                backTrace(digits, index+1, path, ans);
                path.deleteCharAt(path.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        String digits = "23";
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations(digits).toString());
    }
}
