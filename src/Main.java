import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 21:48 2021/10/30
 */
public class Main {

    public static long calculate(int num){
        if(num == 0) return 0;
        if(num==1 || num==2 || num==3) return 1;

        String[] dp = new String[num+1];
        dp[0] = "0";
        dp[1] = "1";
        dp[2] = "1";
        dp[3] = "1";

        for (int i = 4; i <= num; i++) {
            dp[i] = addStrings(addStrings(dp[i-1], dp[i-2]), dp[i-3]);
        }

        return stringMod(dp[num]);
    }

    // 字符串相加
    public static String sub(String num1, String num2) {
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

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--,j--){
            int num1c = 0;
            if(i >= 0){
                num1c = num1.charAt(i) - '0';
            }
            int num2c = 0;
            if(j >= 0){
                num2c = num2.charAt(j) - '0';
            }
            int sum = num1c + num2c + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if(carry > 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    // 字符串逆序
    public static String reverse(String s){
        StringBuilder stringBuilder = new StringBuilder();
        int len = s.length();
        for (int i = len-1; i >= 0; i--) {
            stringBuilder.append( s.charAt(i) );
        }
        return stringBuilder.toString();
    }

    // 字符串取模
    public static long stringMod(String s){
        int len = s.length();
        long res = 0;
        for (int i = 0; i < len; i++) {
            res = (res*10 + s.charAt(i)-'0') % 425;
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println( calculate(num) );
    }
}
