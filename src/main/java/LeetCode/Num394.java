package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:11 2022/4/12
 */
public class Num394 {
    /*static class Solution {
        public String decodeString(String s) {
            Stack<Integer> numStack = new Stack<>();
            Stack<StringBuffer> stringStack = new Stack<>();
            StringBuffer ans = new StringBuffer();
            int multi = 0;

            for(char character : s.toCharArray()){
                if(Character.isDigit(character)){
                    multi = multi*10 + character-'0';
                }
                else if(character == '['){
                    numStack.push(multi);
                    multi = 0;
                    stringStack.push(ans);
                    ans = new StringBuffer();
                }
                else if (Character.isAlphabetic(character)) {
                    ans.append(character);
                }
                else{
                    StringBuffer ansTmp=stringStack.pop();
                    int tmp=numStack.pop();
                    for(int i=0;i<tmp;i++)ansTmp.append(ans);
                    ans=ansTmp;
                }
            }

            return ans.toString();
        }
    }*/

    static class Solution {
        public String decodeString(String s) {
            StringBuilder builder = new StringBuilder();
            int num = 0;
            Deque<Integer> numList = new LinkedList<>();
            Deque<StringBuilder> stringList = new LinkedList<>();

            for (char c : s.toCharArray()) {
                if(c>='0' && c<='9'){
                    num = num*10 + (c-'0');
                }
                else if(c == '['){
                    numList.addLast(num);
                    stringList.addLast(builder);
                    num = 0;
                    builder = new StringBuilder();
                }
                else if(c == ']'){
                    StringBuilder temp = stringList.removeLast();
                    int count = numList.removeLast();
                    for (int i = 1; i <= count; i++) {
                        temp.append(builder);
                    }
                    builder = temp;
                }
                else {
                    builder.append(c);
                }
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }
}
