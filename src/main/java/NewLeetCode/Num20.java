package NewLeetCode;

import java.util.Stack;

/**
 * 有效的括号
 * 类型：栈
 */
public class Num20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)){
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {

    }
}
