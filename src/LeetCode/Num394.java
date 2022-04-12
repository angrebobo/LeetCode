package LeetCode;

import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:11 2022/4/12
 */
public class Num394 {
    static class Solution {
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
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }
}
