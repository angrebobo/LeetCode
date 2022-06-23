package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:13 2022/6/23
 */
public class Num43 {
    static class Solution {
        public String multiply(String num1, String num2) {
            if("0".equals(num1) || "0".equals(num2))
                return "0";

            StringBuilder res = new StringBuilder();
            int carry = 0;
            for (int i = num2.length()-1; i >= 0; i--) {
                StringBuilder temp = new StringBuilder();

                //num2中除了最后一个数字，其他数字与num1相乘需要补0
                for (int j = 0; j < num2.length()-1-i; j++) {
                    temp.append(0);
                }
                int n2 = num2.charAt(i) - '0';

                for (int j = num1.length()-1; j >= 0 || carry != 0; j--) {
                    int n1 = (j < 0) ? 0 : (num1.charAt(j) - '0');
                    int product = n1 * n2 + carry;
                    temp.append(product % 10);
                    carry = product / 10;
                }

                res = addStr(res, temp);
            }

            return res.reverse().toString();
        }

        public StringBuilder addStr(StringBuilder s1, StringBuilder s2){
            StringBuilder res = new StringBuilder();
            int carry = 0;
            int i = 0, j = 0;
            while (i < s1.length() || j < s2.length()){
                int n1 =  i < s1.length() ? s1.charAt(i)-'0' : 0;
                int n2 = j < s2.length() ? s2.charAt(j)-'0' : 0;
                int add = n1 + n2 + carry;
                res.append(add % 10);
                carry = add / 10;
                i++;j++;
            }
            if(carry == 1) res.append(1);
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("123456789", "987654321"));
    }
}
