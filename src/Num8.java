/**
 * @author: HuangSiBo
 * @Description:字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Data: Created in 15:21 2021/3/31
 */
public class Num8 {
    public static int myAtoi(String s) {
        int len = s.length();
        if(len == 0)
            return 0;

        int i = 0;
        //sign 表示正负号，1为正，-1为负
        int sign = 1;
        char[] ans = s.toCharArray();


        //处理开头的空格
        while (i < len && ans[i] == ' ')
            i++;
        if(i == len)
            return 0;


        //处理符号
        if(ans[i]=='+' || ans[i]=='-'){
            if(ans[i]=='-')
                sign = -1;
            i++;
        }
        if(i == len)
            return 0;


        int res = 0;
        while (i < len){
            if(ans[i]<'0' || ans[i]>'9'){
                return res;
            }
            //判断res是否超出int限制
            if( (res > Integer.MAX_VALUE/10) || (res==Integer.MAX_VALUE/10 && ans[i]-'0' > Integer.MAX_VALUE%10) )
                return Integer.MAX_VALUE;
            else if( (res < Integer.MIN_VALUE/10) || (res == Integer.MIN_VALUE/10 && ans[i]-'0' > -(Integer.MIN_VALUE%10) ) )
                return Integer.MIN_VALUE;

            res *= 10;
            res += (ans[i] - '0') * sign;

            i++;
        }

        return res;
    }


    public static void main(String[] args) {
        String a = "-2147483647";
        System.out.println(myAtoi(a));
    }
}
