package 面试题.百度.四月十二日;

/**
 * @author: HuangSiBo
 * @Description:
 * 给你两个等长的数组 A 和 B，可以使用一次 “魔法” 将 A[i] 变成 B[i]；
 * 问你把 A 数组变成单调递增的数组最少需要多少次魔法，如果不能就输出 -1
 * @Data: Created in 16:17 2022/4/19
 */
public class Num2 {

    static int len;
    static int ans = Integer.MAX_VALUE;
    public static void dfs(int[] A, int[] B, int index, int count){
        if(index == len){
            if(isIncrease(A, index))
                ans = Math.min(ans, count);
            return;
        }
        if(!isIncrease(A, index))
            return;

        dfs(A, B, index+1, count);

        int temp = A[index];
        A[index] = B[index];
        dfs(A, B, index+1, count+1);
        A[index] = temp;
    }


    public static boolean isIncrease(int[] A, int limit){
        for (int i = limit-1; i > 0; i--) {
            if(A[i] <= A[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = new int[]{6, 5, 8};
        int[] B = new int[]{0, 7, 4};
        len = A.length;
        dfs(A, B, 0, 0);
        System.out.println(ans);
    }
}
