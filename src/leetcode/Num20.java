package leetcode;

import java.util.Stack;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/6/9 10:44
 */

public class Num20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='[')
                stack.push(s.charAt(i));
            else if(s.charAt(i)==')'){
                if(stack.isEmpty() || stack.pop()!='(')
                    return false;
            }
            else if(s.charAt(i)=='}'){
                if(stack.isEmpty() || stack.pop()!='{')
                    return false;
            }
            else if(s.charAt(i)==']'){
                if(stack.isEmpty() || stack.pop()!='[')
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = ")";
        System.out.println(isValid(s));
    }
}
