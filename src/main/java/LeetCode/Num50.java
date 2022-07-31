package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:42 2022/7/27
 */
public class Num50 {
    static class Solution {
        public double myPow(double x, int n) {
            if(n == 0) return 1;
            double res = 1.0;
            for(int i = 0; i < Math.abs(n); i++)
                res *= x;
            if(n > 0) return res;
            else return 1/res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.0, -2));
    }
}
