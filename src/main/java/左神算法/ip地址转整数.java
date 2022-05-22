package 左神算法;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 给你一个IP4的地址，请转成十进制整数
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 *
 * 输入
 * 10.0.3.193
 * 167969729
 * 输出
 * 167773121
 * 10.3.3.193
 *
 * 题解：https://blog.csdn.net/zdfunk/article/details/119609017
 * @Data: Created in 13:42 2022/5/22
 */
public class ip地址转整数 {

    public static long encode(String s){
        String[] ip = s.split("\\.");
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < ip.length; i++) {
            String ss = Integer.toBinaryString(Integer.parseInt(ip[i]));
            if(ss.length() < 8){
                for (int j = 0; j < 8-ss.length(); j++) {
                    builder.append("0");
                }
            }
            builder.append(ss);
        }

        return Long.parseLong(builder.toString(), 2);
    }

    public static String decode(String s){
        String ss = Long.toBinaryString(Long.parseLong(s));
        StringBuilder stringBuilder = new StringBuilder();
        if(ss.length() < 32){
            for (int i = 0; i < 32-ss.length(); i++) {
                stringBuilder.append("0");
            }
        }
        stringBuilder.append(ss);

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            String temp = stringBuilder.substring(i*8, (i+1)*8);
            Integer ip = Integer.parseInt(temp, 2);
            res.append(ip).append(".");
        }
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            long res1 = encode(s1);
            System.out.println(res1);
            String res2 = decode(s2);
            System.out.println(res2);
        }
    }
}
