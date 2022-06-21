package LeetCode;

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
            List<String> res = new LinkedList<>();
            int len = s.length();
            //ip地址最短长度为4，最长长度为12
            if(len < 4 || len > 12)
                return res;

            List<String> ip = new LinkedList<>();
            dfs(0, 0, ip, len, res, s);
            return res;
        }

        /**
         *
         * @param splitTimes 当前分段次数
         * @param begin 从下标begin处开始分段
         * @param ip
         * @param len
         * @param res
         * @param s
         */
        public void dfs(int splitTimes, int begin, List<String> ip, int len, List<String> res, String s){
            //当分段次数达到4次并且
            if(splitTimes==4 && begin==len)
                res.add( String.join(".", ip) );

            //当剩余长度过短或者过长，停止分段
            if(len-begin < 4-splitTimes || len-begin > 3*(4-splitTimes))
                return;

            for (int i = 0; i < 3; i++) {
                if(begin + i >= len)
                    break;

                int isValid = isValidIpAddress(s, begin, begin+i);
                if(isValid != -1){
                    ip.add(isValid + "");
                    dfs(splitTimes+1, begin+i+1, ip, len, res, s);
                    ip.remove(ip.size()-1);
                }
            }
        }

        /**
         * 判断s的[begin，end]分段是否是一个合法分段
         * @param s
         * @param begin
         * @param end
         * @return
         */
        public int isValidIpAddress(String s, int begin, int end){
            int len = end - begin + 1;
            //不能以0开头
            if(len > 1 && s.charAt(begin)=='0')
                return -1;

            String temp = s.substring(begin, end+1);
            int res = Integer.parseInt(temp);
            //不能大于255
            if(res > 255)
                return -1;

            return res;
        }
    }

    public static void main(String[] args) {
        String s = "25525511135";
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses(s));
    }
}
