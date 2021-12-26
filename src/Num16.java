import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description: 16. 最接近的三数之和
 * @Data: Created in 9:45 2021/4/9
 */
public class Num16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int len = nums.length;
        int tempAns = nums[0] + nums[1] + nums[2];
        if(len == 3)
            return tempAns;

        for (int i = 0; i < len; i++) {
            int L = i+1;
            int R = len-1;
            while (L<R){
                int tempSum = nums[i] + nums[L] + nums[R];
                if( Math.abs(tempSum-target) <= Math.abs(tempAns-target) )
                    tempAns = tempSum;

                if(tempSum < target)
                    L++;
                else if(tempSum > target)
                    R--;
                else
                    return tempAns;
            }
        }

        return tempAns;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
