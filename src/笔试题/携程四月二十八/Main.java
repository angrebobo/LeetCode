package 笔试题.携程四月二十八;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目比较一般，用暴力解能过一些，看来还是要好好学动态规划
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> num = new LinkedList<>();
        Deque<Integer> count = new LinkedList<>();
        for (int i = 0; i < n; i++){
            int temp = sc.nextInt();
            if(num.size()>0 && temp==num.getLast()){
                int c = count.pollLast();
                count.add(c+1);
            }
            else {
                num.add(temp);
                count.add(1);
            }
        }

        int len = num.size();
        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int c = count.pollFirst();
            if(c == 1)
                ans.append(num.pollFirst()).append(" ");
            else
                ans.append(num.pollFirst()).append("(").append(c).append(")").append(" ");
        }
        System.out.println(ans);


    }
}
