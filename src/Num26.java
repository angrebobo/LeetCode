/**
 * @author: HuangSiBo
 * @Description: 26. 删除有序数组中的重复项
 * @Data: Created in 10:55 2021/4/9
 */
public class Num26 {
    //解法1
    /*public static int removeDuplicates(int[] nums) {
        int num = 0;
        int L;
        int R = 0;
        while (R < nums.length){
            L = R;
            num++;
            if(R > 0)
                nums[num-1] = nums[R];
            R = L+1;
            while (R < nums.length){
                if(nums[L] == nums[R])
                    R++;
                else
                    break;
            }
        }
        return num;
    }*/

    //解法2
    public static int removeDuplicates(int[] nums) {
        int L = 0;
        int R = 1;
        while (R < nums.length){
            if(nums[L] == nums[R]){
                R++;
            }
            else {
                nums[++L] = nums[R];
            }
        }
        return L+1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
