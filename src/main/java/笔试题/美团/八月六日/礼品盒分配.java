package 笔试题.美团.八月六日;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：
 * 小美做饼干，有AB两种，做成礼盒卖，每个礼盒三个饼干，
 * 且至少包含一个A 和 一个B。现在给你A和B的数量，问最多可以做多少礼盒？
 * 思路：有些礼盒是2A1B,有些是2B1A
 * @Data: Created in 17:18 2022/8/12
 */
public class 礼品盒分配 {
    public static int calculate(int A, int B){
        int min = Math.min(A, B);
        int max = Math.max(A, B);
        // max比min的2倍还大，那最多做min个礼盒
        if(max >= 2*min)
            return min;
        else
            return (A+B)/3;
    }


    public static void main(String[] args) {
        int A = 10;
        int B = 15;
        System.out.println(calculate(A, B));
    }
}
