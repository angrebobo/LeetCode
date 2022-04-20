package LeetCode;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小王做试卷，试卷总分100分
 * 题型是10个选择题，每题2分；10题多选题，每题4分。5题大题，每题8分。
 * 必须按顺序做题。如果小王做错的题累积达到3题，立刻结束考试并计算成绩。
 * 现在给出小王的成绩，计算小王的答题情况次数。
 *
 * 输入：94分
 * 输出：100
 *
 * 94分，表示做错一题选择题，一题多选题。10*10=100
 *
 *
 * 1,1,2,0,0,4,5
 * /1/2
 * 4,5,0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> set = new HashSet<>();
        dfs(100-n, 0, 0, 0, set);
        int ans = 0;
        for (String s : set){
            int count1 = s.charAt(0) - '0';
            int count2 = s.charAt(1) - '0';
            int count3 = s.charAt(2) - '0';
            int temp = 1;
            if(count1!=0)
                temp *= num(10) / (num(count1) * num(10-count1));
            if(count2!=0)
                temp *= num(10) / (num(count2) * num(10-count2));
            if(count3!=0)
                temp *= num(5) / (num(count3) * num(5-count3));
            ans += temp;
        }
        System.out.println(ans);
    }

    public static int num(int n){
        int sum;
        if(n == 1 || n==0)
            return 1;
        else{
            sum = n * num(n-1);
            return sum;
        }
    }


    public static void dfs(int n ,int count1, int count2, int count3, Set<String> set){
        if(n < 0)
            return;
        if(count1 >= 3)
            return;
        if(count1 + count2 >= 3)
            return;
        if(count1 + count2 + count3 >= 3)
            return;
        if(count2>3 || count3>3)
            return;

        if(n == 0){
            String s = "" + count1+count2+count3;
            set.add(s);
            return;
        }


        dfs(n-2, count1+1, count2, count3, set);
        dfs(n-4, count1, count2+1, count3, set);
        dfs(n-8, count1, count2, count3+1, set);
    }
}
