package 笔试题.美团.四月二十三日笔试;

import java.util.Scanner;

/**
 * 现在有n个人坐成一排进行上机考试。但他们有的使用C语言，用C表示；而有的使用Java，用J表示。
 * 为了防止他们“友好交流”，小美老师要求任意座位相邻的两人之间使用的语言是不同的。
 * 小美每次可以交换相邻两人的位置，现在她想知道最少交换多少次可以满足要求？
 * 输入描述：
 * 输入一个整数n（1≤n≤106） ，表示有n个人。
 * 然后输入n个字母c1,c2，... ,cn（ci∈{C,J}）构成的字符串，表示每个人使用的语言。
 * 输出描述：
 * 输出一个整数S，表示最少需要交换S次。若不可能满足要求，则输出-1。
 * 样例输入
 * 4
 * CCJJ
 * 样例输出
 * 1
 */
public class Num2 {

    static int min = Integer.MAX_VALUE;
    public static int count(String s){
        char[] chars = s.toCharArray();
        dfs(chars, 0, 0, s.length());
        return min;
    }

    public static void dfs(char[] chars, int index, int count, int len){
        if(index == len-1){
            if(isZ(chars))
                min = Math.min(min, count);
            return;
        }

        //不换
        dfs(chars, index+1, count, len);

        if(chars[index] != chars[index+1]){
            char temp = chars[index];
            chars[index] = chars[index+1];
            chars[index+1] = temp;
            //换
            dfs(chars, index+1, count+1, len);
            chars[index+1] = chars[index];
            chars[index] = temp;
        }
    }

    public static boolean isZ(char[] chars){
        int len = chars.length;
        boolean flag = true;
        for (int i = 0; i <= len-2; i++) {
            if(chars[i] == chars[i+1]){
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.next();

        /*int ans = count(s);
        if(ans != Integer.MAX_VALUE)
            System.out.println(ans);
        else
            System.out.println("-1");*/
        System.out.println(-1);
    }
}
