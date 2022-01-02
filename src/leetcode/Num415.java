package leetcode;

public class Num415 {

    /*public static String addStrings(String num1, String num2) {
        char[] num_1 = reverse(num1).toCharArray();
        char[] num_2 = reverse(num2).toCharArray();
        int maxLen = 0, minLen = 0;
        if(num1.length() > num2.length()){
            maxLen = num1.length();
            minLen = num2.length();
        }else {
            maxLen = num2.length();
            minLen = num1.length();
        }

        char[] ans = new char[maxLen+1];
        for (int i = 0; i < maxLen+1; i++) {
            ans[i] = '0';
        }

//        for (int i = 0; i < minLen; i++) {
//             if((num_1[i]-'0') + (num_2[i]-'0') > 10)
//        }


        return "0";
    }

    public static String reverse(String s) {
        int length = s.length();
        if (length <= 1)
            return s;
        String left = s.substring(0, length / 2);
        String right = s.substring(length / 2, length);
        return reverse(right) + reverse(left);
    }*/

    static class Solution {
        public String addStrings(String num1, String num2) {
            String longStr;
            String shortStr;
            int min_len;
            int max_len;
            if(num1.length() > num2.length()){
                longStr = num1;
                shortStr = num2;
                min_len = num2.length();
                max_len = num1.length();
            }
            else {
                longStr = num2;
                shortStr = num1;
                min_len = num1.length();
                max_len = num2.length();
            }
            StringBuilder res = new StringBuilder();

            longStr = reverse(longStr);
            shortStr = reverse(shortStr);

            // 进位
            int carry = 0;
            for (int i = 0; i < min_len; i++) {
                int sum = longStr.charAt(i)-'0' + shortStr.charAt(i)-'0' + carry;
                if(sum >= 10){
                    sum %= 10;
                    carry = 1;
                }else {
                    carry = 0;
                }

                res.append(sum);
            }

            for (int i = min_len; i < max_len; i++) {
                int sum = longStr.charAt(i)-'0' + carry;
                if(sum >= 10){
                    sum %= 10;
                    carry = 1;
                }else {
                    carry = 0;
                }

                res.append(sum);
            }
            if(carry == 1)
                res.append("1");

            return reverse(res.toString());
        }

        /**
         * @Description 将字符串逆序
         * @param
         * @return
         */
        public String reverse(String s){
            StringBuilder stringBuilder = new StringBuilder();
            int len = s.length();
            for (int i = len-1; i >= 0; i--) {
                stringBuilder.append( s.charAt(i) );
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        String num1 = "3213534534";
        String num2 = "4234624234234798798659743739857938";

        Solution solution = new Solution();
        System.out.println(solution.addStrings("1", "9"));

    }
}
