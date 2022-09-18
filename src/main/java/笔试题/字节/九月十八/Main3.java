package 笔试题.字节.九月十八;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:18 2022/9/18
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length()>1)
            System.out.println(8);
        else
            System.out.println(3);
    }
}
