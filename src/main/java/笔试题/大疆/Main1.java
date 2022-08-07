package 笔试题.大疆;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 16:18 2022/8/7
 */
public class Main1 {

    public static int getStr(String s){
        int n = s.length();
        int ret = 0;
        Stack<Integer> c = new Stack<>();
        c.push(0);
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            if (ch == '[') {
                c.push(1);
            } else if (ch == ']') {
                if (i < n-1 && (Character.isDigit(s.charAt(i+1)))) {
                    c.push(c.pop() * (s.charAt(i+1) - '0'));
                    i = i+1;
                }
                c.push(c.pop() + c.pop());
            }
        }
        while(!c.empty())
            ret += c.pop();
        return ret;
    }

    public static void main(String[] args) {
        String s = "[[]2]";
        System.out.println(getStr(s));
    }
}
