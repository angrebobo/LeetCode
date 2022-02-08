package LeetCode;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:47 2021/9/28
 */
public class Num1000 {

    public static int[] function1(int[] nums, int k){
        int len = nums.length;
        int[] res = new int[len];
        int index = 0;
        for (int i = 0; i < len; i++) {
            index = (i + k)%len;
            res[index] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] res = function1(nums, 3);
        for(int i : res){
            System.out.print(i + " ");
        }
    }
}
