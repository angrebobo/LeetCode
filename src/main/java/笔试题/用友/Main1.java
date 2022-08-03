package 笔试题.用友;

import java.util.Arrays;

/**
 * 城管队员需要查看，楼顶是否有加盖的违规建筑，一条步行街上有很多高楼，
 * 共有n座高楼排成行。城管队员第一次需要统计每栋楼顶上可以看见几栋
 * 楼的楼顶(当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住)
 * 便于以后只选择到几栋楼，就可以看见全部高楼的楼顶是否有违建。
 * 如步行街，上有高度依次为{50m, 30m 80m, 30m, 27m, 57m}的六栋大楼，
 * 当站在第3栋大楼上时，可以看见5栋大楼顶部是否有违规建筑(当处于第3栋楼，可
 * 以向前看到位置2处的楼，向后看到位置4、6处的楼，加上第3栋楼，共可看到5幢楼
 * 请用代码求解，当大楼的高度依次为数组{a1,a2,...,an}时
 * 站在每个大楼上可以看见的大楼楼顶数量的数组[b1,b2...,bn]
 * 输入：50, 30, 80, 30, 27, 57
 * 输出：[3,3,5,4,4,4]
 */
public class Main1 {

    public static int[] findBuilding (int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] += back(heights, i);
            res[i] += go(heights, i);
            res[i] += 1;
        }

        return res;
    }

    public static int back(int[] heights, int index){
        if(index == 0) return 0;

        // index左边的那幢楼一定看得见
        int count = 1;
        int max = heights[index-1];

        for (int i = index-2; i >= 0; i--) {
            if(heights[i] > max){
                count++;
                max = heights[i];
            }
        }
        return count;
    }

    public static int go(int[] heights, int index){
        if(index == heights.length-1)
            return 0;

        //index右边那幢楼一定看得见
        int count = 1;
        int max = heights[index+1];
        for (int i = index+2; i < heights.length; i++) {
            if(heights[i] > max){
                count++;
                max = heights[i];
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{50, 30, 80, 30, 27, 57};
        System.out.println(Arrays.toString(findBuilding(nums)));
    }
}
