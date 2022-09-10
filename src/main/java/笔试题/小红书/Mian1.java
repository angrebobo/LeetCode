package 笔试题.小红书;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:30 2022/9/4
 */
public class Mian1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        sc.nextLine();
//        StringBuilder s = new StringBuilder();
        int[] nums = new int[n*2];
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            nums[i] = temp;
            nums[n*2-1-i] = temp;
//            s.append( sc.nextInt() );
        }
//        for (int i = 0; i < m; i++) {
//            s.append( s.reverse() );
//        }
//        System.out.println(s.charAt((int) (k-1)));

//        if(k<=n*2){
//            System.out.println( nums[k-1] );
//        }
//        else {
//            k %= (n*2);
//            System.out.println( nums[k-1] );
//        }
//        if(k<=n* 2L){
//            System.out.println( s.charAt((int) (k-1)) );
//        }
//        else {
//            k %= (n* 2L);
//            System.out.println( s.charAt((int) (k-1)) );
//        }

        if(m == 1){
            System.out.println( nums[(int) (k-1)] );
        }
        else {
            k %= (n* 2L);
            System.out.println( nums[(int) (k-1)] );
        }
    }
}
