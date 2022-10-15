import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:54 2022/9/17
 *
 * 有n个学生，站成一排. 每个学生都有个分数值
 * You need give apples to these kids with following requirements:
 *     1, Each kid has least one apple.
 *     2, 分数越高的学生 will get more apples than neighbours
 * you need to return the minimum number of apples needed.
 *
 * Example 1:
 * Input: scores = [1,0,2]
 * Output: 5
 * Explanation: You can allocate 2, 1, 2 apples respectively.
 * Example 2:
 * Input: scores = [1,2,2]
 * Output: 4
 * Explanation: you can allocate 1,2,1 to kids respectively
 *
 * Constraints:
 *     n == ratings.length
 *     1 <= n <= 2 * 104
 *     0 <= ratings[i] <= 2 * 104
 */
public class Test {

    public static long calculate(int[] scores){
//        int min_index = 0;
//        int min = scores[0];
//        int len = scores.length;
//        for (int i = 1; i < len; i++) {
//            if(scores[i] < min){
//                min = scores[i];
//                min_index = i;
//            }
//        }
//
//        int count = 0;
//        int[] dp = new int[len];
//        dp[min_index] = 1;
//        for (int i = min_index+1; i < len; i++) {
//            if(scores[i] > scores[i-1])
//                dp[i] = dp[i-1]+1;
//            else
//                dp[i] = 1;
//        }
//        for (int i = len-1; i > min_index; i--) {
//
//        }

        int len = scores.length;
        int[] count = new int[len];
        Arrays.fill(count, 1);
        for (int i = 0; i < len; i++) {
            if(i==0){
                if(i+1<len && scores[i] < scores[i+1]){
                    count[i] = 1;
                    int right = i+1;
                    while (right<len && scores[right]>scores[right-1]){
                        count[right] = Math.min(count[right], count[right-1] + 1);
                        right++;
                    }
                }
            }
            else if(i == len-1){
                if(scores[i-1] > scores[i]){
                    count[i] = 1;
                    int left = i-1;
                    while (left-1>=0 && scores[left]>scores[left+1]){
                        count[left] = Math.min(count[left], count[left+1]+1);
                        left--;
                    }
                }
            }
            else {

            }
        }

    }

    public static void main(String[] args) {
        int[] scores = new int[]{1,2,2};
        System.out.println(calculate(scores));
    }
}
