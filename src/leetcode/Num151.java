package leetcode;

import java.util.*;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/7/31 16:18
 */

public class Num151 {

    /**
     * 方法1，用栈
     * @param s
     * @return
     */
    /*
    public static String reverseWords(String s) {
        StringBuilder temp = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i) == ' '){
                if(temp.length()==0)
                    continue;
                else{
                    stack.push(temp.toString());
                    temp.delete(0, temp.length());
                }
            }
            else{
                temp.append( s.charAt(i) );

                if(i == len-1)
                    stack.push(temp.toString());
            }

        }

        temp.delete(0, temp.length());
        len = stack.size();
        for (int i = 0; i < len; i++) {
            temp.append( stack.pop() );
            if(i != len-1)
                temp.append(" ");
        }

        return temp.toString();
    }*/


    public static String reverseWords(String s){
        s = s.trim();
        List<String> strings = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strings);
        return String.join(" ", strings);
    }


    public static void main(String[] args) {
        String s = "a good     example";
        System.out.println(reverseWords(s));
    }
}
