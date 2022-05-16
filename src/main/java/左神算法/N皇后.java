package 左神算法;

/**
 * @author: HuangSiBo
 * @Description:
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，要求任何两个皇后不同行、不同列，也不在同一条斜线上，
 * 给定一个整数n,返回n皇后的摆法有多少种。n=1,返回1。n=2或3,2皇后和3皇后问题无论怎么摆都不行，返回0
 * n=8,返回92
 * @Data: Created in 20:21 2022/5/11
 */
public class N皇后 {
    public static int num1(int n){
        if(n < 1)
            return 0;
        int[] record = new int[n];
        return process1(0, record, n);
    }

    public static int process1(int i, int[] record, int n){
        if(i == n)
            return 1;
        int res = 0;
        for (int j = 0; j < n; j++) {
            if(isValid(i, j, record)){
                record[i] = j;
                res += process1(i+1, record, n);
            }
        }
        return res;
    }

    public static boolean  isValid(int i, int j, int[] record){
        for (int k = 0; k < i; k++) {
            //判断是否在同一列或者在同一斜线上
            if(j == record[k] || Math.abs(record[k]-j)==Math.abs(i-k))
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(num1(8));
    }
}
