package LeetCode;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * 逆波兰式表达式求结果
 * @Data: Created in 21:47 2022/6/1
 */
public class Num150 {
    static class Solution {
        /*public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();

            for (int i = 0; i < tokens.length; i++) {
                if(Character.isDigit(tokens[i].charAt(0))){
                    stack.push(tokens[i]);
                }
                // 负数
                else if(tokens[i].charAt(0)=='-' && tokens[i].length()>1){
                    stack.push(tokens[i]);
                }
                else {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int afterOption = 0;
                    switch (tokens[i]){
                        case "+":
                            afterOption = b+a;
                            break;
                        case "-":
                            afterOption = b-a;
                            break;
                        case "*":
                            afterOption = b*a;
                            break;
                        case "/":
                            afterOption = b/a;
                            break;
                    }
                    stack.push(String.valueOf(afterOption));
                }
            }

            return Integer.parseInt(stack.pop());
        }*/

        public int evalRPN(String[] tokens){
            Stack<Integer> stack = new Stack<>();

            int a;
            int b;
            for(String s : tokens){
                switch (s){
                    case "+":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b+a);
                        break;
                    case "-":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b-a);
                        break;
                    case "*":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b*a);
                        break;
                    case "/":
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b/a);
                        break;
                    default:
                        stack.push(Integer.valueOf(s));
                }
            }

            return stack.pop();
        }
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2","-1","-"};
        Solution solution = new Solution();
        System.out.println(solution.evalRPN(tokens));
    }
}
