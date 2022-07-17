package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:45 2022/7/16
 */
public class Num440 {
    static class Solution {
        public int findKthNumber(int n, int k) {
            List<String> list = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                list.add(i + "");
            }

            list.sort((o1, o2) -> {
                int len = Math.min(o1.length(), o2.length());
                for (int i = 0; i < len; i++) {
                    if(o1.charAt(i) < o2.charAt(i))
                        return -1;
                    else if(o1.charAt(i) > o2.charAt(i))
                        return 1;
                }
                if(len < o1.length())
                    return 1;
                else if(len < o2.length())
                    return -1;
                else return 0;
            });

            return Integer.parseInt(list.get(k-1));
        }
    }

    public static void main(String[] args) {
        int n = 1;
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.findKthNumber(n, k));
    }
}
