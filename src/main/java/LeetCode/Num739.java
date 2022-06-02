package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author: HuangSiBo
 * @Description:
 * 知识点：单调栈
 * 题解：https://programmercarl.com/0739.%E6%AF%8F%E6%97%A5%E6%B8%A9%E5%BA%A6.html#%E6%80%9D%E8%B7%AF
 * @Data: Created in 23:39 2022/6/2
 */
public class Num739 {
    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int len = temperatures.length;
            //stack为单调栈，存储元素的下标（存下标很妙）
            //stack单调的顺序是从栈头到栈底是递增的
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int[] res = new int[len];

            for (int i = 1; i < len; i++) {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.pop();
                }
                stack.push(i);
            }

            return res;
        }
    }

    public static void main(String[] args) {
        int[] temperature = new int[]{73,74,75,71,69,72,76,73};
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.dailyTemperatures(temperature)));
    }
}
