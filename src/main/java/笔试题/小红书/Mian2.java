package 笔试题.小红书;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 15:30 2022/9/4
 */
public class Mian2 {

    /*static int min = Integer.MAX_VALUE;
    public static void dfs(int[] nums, int count, int index, int op){
        if(count > min)
            return;

        if(check(nums)){
            min = Math.min(min, count);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            nums[i] = temp-1;
            dfs(nums, count+1);

            nums[i] = temp+1;
            dfs(nums, count+1);
            nums[i] = temp;

            dfs(nums, count);
        }
    }

    public static boolean check(int[] nums){
        long ans = 1L;
        for (int num : nums) {
            ans *= num;
            if(ans > 7 || ans < -7)
                return false;
        }

        return ans==7L;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(nums, 0);
        System.out.println(min);
    }*/
}
