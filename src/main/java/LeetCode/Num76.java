package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * 题解：https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/
 * @Data: Created in 22:40 2022/7/2
 */
public class Num76 {
    static class Solution {
        //方法1，滑动窗口
        /*public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
                need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
            }
            int res_len = Integer.MAX_VALUE;
            StringBuilder res = new StringBuilder();
            int start=0, end=0;
            while (end < s.length()){
                // 使end往右移动，直到子串符合要求
                while (!isComplete(map) && end<s.length()){
                    char c = s.charAt(end);
                    if(need.containsKey(c))
                        map.put(c, map.get(c)-1);
                    end++;
                }
                if(!isComplete(map))
                    break;
                // 使start也往右移动，排除无用元素，直到s.charAt(start)是所需字母
                while (start <= end-1){
                    char c = s.charAt(start);
                    if(need.containsKey(c)){
                        if(map.get(c) == 0){
                            // 符合的子串下标是start -> end-1
                            if(end-start < res_len){
                                res = new StringBuilder(s.substring(start, end));
                                res_len = res.length();
                            }
                            start++;
                            map.put(c, map.get(c)+1);
                            break;
                        }
                        else if(map.get(c) < 0)
                            map.put(c, map.get(c)+1);
                    }
                    start++;
                }
            }
            return res.toString();
        }

        public boolean isComplete(HashMap<Character, Integer> map){
            for(Integer integer : map.values()){
                if(integer > 0)
                    return false;
            }
            return true;
        }*/

        public String minWindow(String s, String t){
            int[] map = new int[128];
            int[] need = new int[128];
            for (int i = 0; i < t.length(); i++) {
                map[t.charAt(i)-'0'] += 1;
                need[t.charAt(i)-'0'] += 1;
            }
            int res_len = Integer.MAX_VALUE;
            int res_start=-1;
            int start=0, end=0;
            int count = t.length();
            while (end < s.length()){
                // 使end往右移动，直到子串符合要求
                while (count>0 && end<s.length()){
                    char c = s.charAt(end);
                    if(need[c-'0'] > 0){
                        map[c-'0'] -= 1;
                        count--;
                    }
                    end++;
                }
                if(count > 0)
                    break;
                // 使start也往右移动，排除无用元素，直到s.charAt(start)是所需字母
                while (start <= end-1){
                    char c = s.charAt(start);
                    if(need[c-'0'] > 0){
                        if(map[c-'0'] == 0){
                            // 符合的子串下标是start -> end-1
                            if(end-start < res_len){
                                res_start = start;
                                res_len = end-res_start;
                            }
                            start++;
                            map[c-'0'] += 1;
                            count++;
                            break;
                        }
                        else if(map[c-'0'] < 0)
                            map[c-'0'] += 1;
                    }
                    start++;
                }
            }

            return (res_start>=0)?(s.substring(res_start, res_start+res_len)):("");
        }
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
    }
}
