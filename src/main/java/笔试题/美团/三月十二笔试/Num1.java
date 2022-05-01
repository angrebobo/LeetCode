package 笔试题.美团.三月十二笔试;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description: 美团暑期实习2022/03/12笔试
 * 判断数字是否至少满足以下两个特征的一种：
 *
 * （1）数字是11的整倍数
 *
 * （2）数字中至少包含两个1
 *
 * 是输出“yes”，不是输出“no”
 *
 * @Data: Created in 18:12 2022/4/14
 */
public class Num1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        if(x%11 == 0){
            String s = String.valueOf(x);
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '1')
                    count++;
            }

            if(count == 2)
                System.out.println("yes");
            else
                System.out.println("no");
        }
        else
            System.out.println("no");
    }
}
