package 笔试题.蔚来;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * 输入一个整数n，计算[0,n]区间内每个数的二进制中1的个数，输出一个数组
 * @Data: Created in 14:25 2022/8/1
 */
public class Main1 {
    public int[] countBinary(int n){
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = count(i+1);
        }
        return res;
    }

    public int count(int n){
        // num表示二进制中1的个数
        int num = 0;
        // 十进制转二进制，除2取余法
        while (n != 0){
            num += n%2;
            n /= 2;
        }
        return num;
    }

    public String[] reverseBinary(int n){
        String[] res = new String[n];

        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int num = i+1;
            // 十进制转二进制，除2取余法
            while (num != 0){
                builder.append(num%2);
                num /= 2;
            }
            res[i] = builder.reverse().toString();
        }
        return res;
    }



    public static void main(String[] args) {
        int n = 10;
        Main1 main1 = new Main1();
        System.out.println(Arrays.toString(main1.reverseBinary(n)));
        System.out.println(Arrays.toString(main1.countBinary(n)));
    }
}
