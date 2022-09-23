/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:54 2022/9/17
 */
public class Test {

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 7;

        int left=0, right=nums.length-1;
        int mid=0;
        while (left<right){
            mid = left+(right-left)/2;
            if(nums[mid]<=target)
                left=mid+1;
            else
                right=mid;
        }
        System.out.println(right);
    }
}
