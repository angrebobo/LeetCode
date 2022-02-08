package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:15 2021/10/9
 */
public class Num0 {

    public static Float changeToFloat(String s){
        int len = s.length();
        float res = 0;

        // 判断字符串中的字符全为数字
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '.')
                continue;
            else if(s.charAt(i)-'0' > 9 || s.charAt(i)-'0' < 0){
                return null;
            }
        }

        //判断字符串中是否有小数点
        boolean hasDot = false;
        // 小数点的下标
        int index = 0;
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == '.'){
                hasDot = true;
                index = i;
            }
        }

        if(!hasDot){
            for (int i = len-1; i >= 0; i--) {
                res += (s.charAt(i)-'0') * Math.pow(10, len-1-i);
            }
            return res;
        }
        else {
            // 计算正数部分
            for (int i = index-1; i >= 0; i--) {
                res += (s.charAt(i)-'0') * Math.pow(10, index-1-i);
            }

            // 计算小数部分
            for (int i = index+1; i < len; i++) {
                res += (s.charAt(i)-'0') * Math.pow(10, -1 * (i-index));
            }

            return res;
        }
    }

    public static void main(String[] args) {
        String s = "123.11";
        System.out.println(changeToFloat(s));
    }
}
