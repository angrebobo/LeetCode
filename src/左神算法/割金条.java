package 左神算法;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * 一块金条切成两半，是需要花费和长度数值一样的铜板的。比如长度为20的金条，不管切成长度多大的两半，都要花费20个铜板。
 * 一群人想整分整块金条，怎么分最省铜板？
 * 例如，给定数组{10,20,30}，代表一共三个人，整块金条长度为10+20+30=60.金条要分成10,20,30三个部分。
 * 如果先把长度60的金条分成10和50，花费60;再把长度50的金条分成20和30，花费50；一共花费110铜板。
 * 但是如果先把长度60的金条分成30和30，花费60；再把长度30金条分成10和20, 花费30；一共花费90铜板。
 * 输入一个数组，返回分割的最小代价。
 * @Data: Created in 16:43 2022/4/22
 */
public class 割金条 {

    public static int distribute(int[] nums){
        Arrays.sort(nums);
        int len = nums.length-1;
        int min = 0;
        while (len!=0){
            for (int i = 0; i <= len; i++) {
                min += nums[i];
            }
            len--;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10,20,30,40,50};
        System.out.println(distribute(nums));
    }
}
