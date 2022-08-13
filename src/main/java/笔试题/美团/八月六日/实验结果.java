package 笔试题.美团.八月六日;

/**
 * @author: HuangSiBo
 * @Description:https://blog.csdn.net/weixin_41896265/article/details/126219179
 * 小美做实验，有一个纸带上有若干个数字，在纸带上选择一个位置k，
 * k是分割点（比如k选3，那么左边是123，右边是456），
 * k左边大于等于0的点为异常点，k右边小于等于0的点为异常点。
 * 现在给一个纸带，不给k，问你最乐观情况下异常点最少个数为多少（选哪个k异常点最少吧）
 * 思路：前缀和
 * @Data: Created in 20:44 2022/8/12
 */
public class 实验结果 {

    public static int calculate(int[] nums){
        int len = nums.length;
        //big代表比0大
        int[] big = new int[len];
        int[] small = new int[len];

        //前缀和数组
        int[] preSumBig = new int[len];
        int[] preSumSmal = new int[len];
        for (int i = 0; i < len; i++) {
            big[i] = (nums[i]>=0)?1:0;
            small[i] = (nums[i]<=0)?1:0;
            if(i==0){
                preSumBig[0] = big[0];
                preSumSmal[0] = small[0];
            }
            else{
                preSumBig[i] = preSumBig[i-1] + big[i];
                preSumSmal[i] = preSumSmal[i-1] + small[i];
            }

        }

        int min = len+1;
        for (int i = 0; i < len; i++) {
            int temp = preSumBig[i] + preSumSmal[len-1] - preSumSmal[i];
            min = Math.min(min, temp);
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-1,4,5,-3,-7,5,0,4,-8,0,0,6,5,523,435,4456,2344,-424,423,-4,-423,0,-42,5,643,21,423,423,5,-3,8,6,645,6};
        System.out.println(calculate(nums));
    }
}
