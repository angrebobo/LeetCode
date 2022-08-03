package LeetCode;

/**
 * @author: HuangSiBo
 * @Description: 将数组向右循环移动m位，比如1234，向右移动2位，就是3412
 * 思路：先将数组前len-m位逆序，然后将后m位逆序，最后将整个数组逆序
 * @Data: Created in 14:17 2022/8/3
 */
public class 数组元素循环右移问题 {

    // 将数组循环往右移动m位
    public static void moveK(int[] nums, int m){
        int len = nums.length;
        m %= len;
        swap(nums, 0, len-m-1);
        swap(nums, len-m, len-1);
        swap(nums, 0, len-1);
    }

    // 将数组left~right逆转
    public static void swap(int[] nums, int left, int right){
        for (int i = left; i <= left+(right-left)/2; i++) {
            int temp = nums[left+right-i];
            nums[left+right-i] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        moveK(nums, 7);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
