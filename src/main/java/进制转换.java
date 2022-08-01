/**
 * @author: HuangSiBo
 * @Description:
 * 博客：https://www.cnblogs.com/gaizai/p/4233780.html
 * @Data: Created in 14:51 2022/8/1
 */
public class 进制转换 {

    // 十进制转二进制
    public static String reverseBinary(int n){
        StringBuilder builder = new StringBuilder();
        // 十进制转二进制，除2取余法
        while (n != 0){
            builder.append(n%2);
            n /= 2;
        }

        return builder.reverse().toString();
    }

    // 十进制转八进制
    public static String reverseOctal(int n){
        StringBuilder builder = new StringBuilder();
        // 十进制转二进制，除2取余法
        while (n != 0){
            builder.append(n%8);
            n /= 8;
        }

        return builder.reverse().toString();
    }


    public static void main(String[] args) {
        int n = 10;
        System.out.println(n);
        System.out.println("转换后的二进制为： " + reverseBinary(n));
        System.out.println("转换后的八进制为： " + reverseOctal(n));
    }
}
