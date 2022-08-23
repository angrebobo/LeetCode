package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:11 2021/8/3
 */
public class Num93 {
    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> ans = new ArrayList<>();
            Deque<String> path = new LinkedList<>();
            if(s.length()<4)
                return ans;

            backTrace(0, 0, s, path, ans);
            return ans;
        }

        //回溯题，其实就是3种选择，选1个字符还是2个字符还是3个字符
        public void backTrace(int splitTimes, int index, String s,
                              Deque<String> path, List<String> ans){

                // splitTimes代表切分次数
                if(splitTimes == 4 && index == s.length()){
                    ans.add(String.join(".", path));
                }

                // 当前切分得太短
                if(index+3*(4-splitTimes) < s.length()-1)
                    return;
                // 当前切分得太长
                if(s.length()-index< 4-splitTimes)
                    return;

                // 回溯的过程，3种长度
                for(int i = 1; i <= 3; i++) {
                    if(index+i > s.length())
                        break;
                    else {
                        String temp = s.substring(index, index + i);
                        if(isVal(temp)) {
                            path.addLast(temp);
                            backTrace(splitTimes + 1, index + i, s, path, ans);
                            path.removeLast();
                        }
                    }
                }
        }

        // 判断选中的字符串是不是合格的ip地址
        public boolean isVal(String s){
            int len = s.length();
            // 不能有前导0
            if(len>1 && s.charAt(0)=='0')
                return false;
            int v = Integer.parseInt(s);
            // 不能大于255
            return v <= 255;
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }
}
