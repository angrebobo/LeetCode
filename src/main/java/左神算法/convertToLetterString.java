package 左神算法;

/**
 * @author: HuangSiBo
 * @Description:
 * 规定1和A对应、2和B对应、3和C对应…那么一个数字字符串比如"111”就可以转化为：'AAA"、 “KA"和"AK”。
 * 给定一个只有数字字符组成的字符串str，返回有多少种转化结果
 * @Data: Created in 15:55 2022/5/5
 */
public class convertToLetterString {
    public static int convert(String s){
        if(s==null || s.length()==0)
            return 0 ;

        char[] temp = s.toCharArray();
        return convertToString(temp, 0);
    }

    public static int convertToString(char[] str, int index){
        // i来到终止位置，没有字符了，转换为空字符
        // 要么认为0~i-1已经转换好了，返回一个点数
        if(index==str.length)
            return 1;
        // i没有到终止位置
        // 0没有对应的字符
        if(str[index]=='0')
            return 0;

        // i没有到终止位置 && i位置不是0字符

        // i位置是1字符，i+1位置无论是什么字符都不会超过26，都可以转换
        if(str[index]=='1') {
            int res=convertToString(str, index+1);// i位置自己单独转换，后续有多少种方法
            if(index+1<str.length) {
                res+=convertToString(str, index+2);// i和i+1位置一起转换，后续有多少种方法
            }
            return res;
        }
        // i位置是2字符，如果i+1位置的字符是0~6，i和i+1就可以一起转换，然后i+2位置接着递归
        // 否则只能i位置自己转换，然后i+1位置接着递归
        if(str[index]=='2') {
            int res=convertToString(str, index+1);
            if(index+1<str.length && (str[index+1]>='0' && str[index+1]<='6')) {
                res+=convertToString(str, index+2);
            }
            return res;
        }
        return convertToString(str, index+1);
    }

    public static void main(String[] args) {
        String s = "111";
        System.out.println(convert(s));
    }
}
