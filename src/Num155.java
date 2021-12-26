import java.util.Stack;

/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/7/17 19:50
 */

public class Num155 {

    static class MinStack {

        private Stack stack = new Stack();
        private int min = Integer.MAX_VALUE;

        /** initialize your data structure here. */
        public MinStack() {}

        public void push(int val) {
            if(val <= min){
                stack.push(min);
                min = val;
            }
            stack.push(val);

        }

        public void pop() {
            if((int)stack.pop() == min){
                min = (int) stack.pop();
            }
        }

        public int top() {
            return (int)stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        System.out.println(stack.getMin());
    }
}
