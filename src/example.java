import java.util.ArrayList;
import java.util.Collections;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:54 2021/9/26
 */
public class example {

    public static int[] plus(int[] nums){
        int len = nums.length;
        int sum = 0;
        for (int i = len-1; i >= 0; i--) {
            sum += nums[i] * Math.pow(10, len-1-i);
        }
        sum += 1;

        ArrayList<Integer> list = new ArrayList<>();
        while (sum != 0){
            list.add( sum%10 );
            sum /= 10;
        }
        Collections.reverse(list);
        int[] ans = list.stream().mapToInt(Integer :: valueOf).toArray();

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        int[] nums1 = new int[]{9,9};
        int[] ans = plus(nums1);
        for (int i : ans){
            System.out.print(i + " ");
        }
    }
}
