package 面试题.华为.四月二十日;


import java.util.Scanner;

/**
 * 小王做试卷，试卷总分100分
 * 题型是10个选择题，每题2分；10题多选题，每题4分。5题大题，每题8分。
 * 必须按顺序做题。如果小王做错的题累积达到3题，立刻结束考试并计算成绩。
 * 现在给出小王的成绩，计算小王的答题情况次数。
 *
 * 输入：94分
 * 输出：100
 *
 * 94分，表示做错一题选择题，一题多选题。10*10=100
 *
 *
 **/
public class Num1 {
    private static int sum = 0;
    private static int N;
    public static int[] scores = {2,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,4,4,4,4,8,8,8,8,8};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N=scanner.nextInt();
        backTracking(0, 0, 0);
        System.out.println(sum);
    }

    public static void backTracking(int index, int score, int err){
        //错误数达到3题或者已经做到最后一题，应结束程序并计算成绩
        if(err == 3 || index == 25){
            if(score == N)
                sum++;
            return;
        }
        if(score == N){
            sum++;
            return;
        }
        //当前分数已经高于N，接下来的题做对做错都会比N高，所以直接return
        if(score > N)
            return;

        backTracking(index+1, score+scores[index], err);

        backTracking(index+1, score, err+1);
    }
}
