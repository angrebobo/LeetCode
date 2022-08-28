package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:字符串转换整数 (atoi) https://leetcode-cn.com/problems/string-to-integer-atoi/
 * @Data: Created in 15:21 2021/3/31
 */
public class Num8 {
    /*public static int myAtoi(String s) {
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
    }*/


    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;

        int index = 0;
        // 去除前导0
        while (index < len && chars[index] == ' '){
            index++;
        }
        if(index == len)
            return 0;

        int sign = 1;
        if(chars[index] == '+' || chars[index] == '-'){
            if(chars[index] == '-')
                sign  = -1;
            index++;
        }

        int res = 0;
        while (index < len){
            char c = chars[index];
            if(c<'0' || c>'9')
                return res;

            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && c-'0'>Integer.MAX_VALUE%10))
                return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE/10 || (res==Integer.MIN_VALUE/10 && c-'0'>-(Integer.MIN_VALUE%10)))
                return Integer.MIN_VALUE;

            res *= 10;
            res += sign==1 ? c-'0' : -(c-'0');
            index++;
        }

        return res;
    }



    public static void main(String[] args) {
        String a = "-214748364753453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453453455465465656756767675675756756756756";
        System.out.println(myAtoi(a));
    }
}
