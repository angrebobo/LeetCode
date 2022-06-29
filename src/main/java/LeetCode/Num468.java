package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:12 2022/6/28
 */
public class Num468 {
    static class Solution {
        public String validIPAddress(String queryIP) {
            if( isIPV4(queryIP) )
                return "IPv4";
            else if( isIPV6(queryIP) )
                return "IPv6";
            else
                return "Neither";
        }

        public boolean isIPV4(String queryIP){
            if("".equals(queryIP) || queryIP.charAt(queryIP.length()-1) == '.')
                return false;
            String[] splits = queryIP.split("\\.");
            int len = splits.length;
            if(len != 4)
                return false;
            for (String split : splits) {
                if (split.length() == 0 || split.length() > 3 || (split.length() > 1 && split.charAt(0) == '0'))
                    return false;
                try {
                    int temp = Integer.parseInt(split);
                    if (temp < 0 || temp > 255)
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }

            return true;
        }

        public boolean isIPV6(String queryIP){
            if("".equals(queryIP) || queryIP.charAt(queryIP.length()-1) == ':')
                return false;
            String[] splits = queryIP.split(":");
            int len = splits.length;
            if(len != 8)
                return false;
            for (String split : splits) {
                if (split.length() == 0 || split.length() > 4)
                    return false;
                for (int j = 0; j < split.length(); j++) {
                    if (split.charAt(j) < '0' ||
                        split.charAt(j) > '9' && split.charAt(j) < 'A' ||
                        split.charAt(j) > 'F' && split.charAt(j) < 'a' ||
                        split.charAt(j) > 'f')
                        return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        String s = "";
        Solution solution = new Solution();
        System.out.println(solution.validIPAddress(s));
    }
}
