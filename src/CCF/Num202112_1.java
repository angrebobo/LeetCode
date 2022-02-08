package CCF;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 题目信息：http://118.190.20.162/view.page?gpid=T138
 * 题解：https://blog.csdn.net/WZZ_2363173126/article/details/122133673
 * @Author HuangSiBo
 * @Date 2022/2/7 23:20
 **/
public class Num202112_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 0; i < n; i++) {
            list.add( sc.nextInt() );
        }
        list.add(N);

        System.out.println( calculate(list) );
    }

    public static int calculate(List<Integer> list){
        int sum = 0;
        for (int i = 0; i < list.size()-1; i++) {
            sum += i * (list.get(i+1) - list.get(i));
        }
        return sum;
    }
}
