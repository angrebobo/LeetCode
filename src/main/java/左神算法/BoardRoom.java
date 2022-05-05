package 左神算法;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。
 * 给你每一个项目开始的时间和结束的时间（给你一个数组，里面是一个个具体的项目），
 * 你来安排宣讲的日程，要求会议室进行的宣讲的场次最多，返回这个最多的宣讲场次。
 * @Data: Created in 15:33 2022/4/22
 */
public class BoardRoom {
    static class Program{
        int start;
        int end;
        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    /**
     * 贪心法，先安排结束时间早的会议
     * @param programs
     * @return
     */
    public static int arrange(Program[] programs){
        //按照结束时间排序
        Arrays.sort(programs, (o1,o2) -> o1.end-o2.end);
        int result = 0;
        int start = programs[0].start;
        for (int i = 0; i < programs.length; i++) {
            if(start <= programs[i].start){
                result++;
                start = programs[i].end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Program program1 = new Program(8,10);
        Program program2 = new Program(10,11);
        Program program3 = new Program(7,11);
        Program program4 = new Program(12,19);
        Program program5 = new Program(13,14);
        Program program6 = new Program(15,16);
        Program program7 = new Program(17,18);
        Program program8 = new Program(20,21);
        Program[] programs = new Program[]{program1,program2,program3,program4,
                program5,program6,program7,program8};

        System.out.println(arrange(programs));
    }
}
