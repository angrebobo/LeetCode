package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: 14. 最长公共前缀
 * @Data: Created in 13:53 2021/4/7
 */
public class Num14 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";

        String ans;

        ans = strs[0];
        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            for (; j<strs[i].length() && j<ans.length(); j++) {
                if(ans.charAt(j) != strs[i].charAt(j))
                    break;
            }
            ans = ans.substring(0, j);
            if(ans.length() == 0)
                break;
        }
        if(ans.length() == 0)
            return "";
        else
            return ans;
    }

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
