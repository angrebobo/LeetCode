package 笔试题.荣耀笔试;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 过了40%
 * @Data: Created in 17:56 2022/9/22
 */
public class Main1 {

    public static void calculate(int n, int version){
        int tempVersion = version;
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        list1.add(1);
        list2.add(1);
        n-=2;
        if(n==0) tempVersion=2;
        int left=1, right=1;

        while (n > 0){
            int temp = left+right;
            if(tempVersion == 1){
                if(n <= temp){
                    list1.add(n);
                    left = n;
                    n = 0;
                }
                else {
                    list1.add(temp);
                    n -= temp;
                    left = temp;
                    tempVersion = 2;
                }
            }
            else {
                if(n <= temp){
                    list2.add(n);
                    right = n;
                    n = 0;
                }
                else {
                    list2.add(temp);
                    n -= temp;
                    right = temp;
                    tempVersion = 1;
                }
            }
        }

        if(tempVersion == version){
            String s;
            if(version==1){
                s = "now is " + list1.size() + " times by left hand";
                System.out.println(s);
                int count = 0;
                for (Integer integer : list1) {
                    count++;
                    if (count % 10 == 0) {
                        System.out.print(integer+"\r\n");
                    } else {
                        System.out.print(integer + " ");
                    }
                }
            }
            else {
                s = "now is " + list2.size() + " times by right hand";
                System.out.println(s);
                int count = 0;
                for (Integer integer : list2) {
                    count++;
                    if (count % 10 == 0) {
                        System.out.println(integer);
                    } else {
                        System.out.print(integer + " ");
                    }
                }
            }
        }
        else {
            String s;
            if(version==1)
                s = "left hand has not touch the ball";
            else
                s = "right hand has not touch the ball";
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.trim().split(",");
        int n = Integer.parseInt(split[0].trim());
        // 1是左手，2是右手
        int version = 1;
        if("right hand".equals(split[1].trim())){
            version = 2;
        }
        calculate(n, version);
    }
}
