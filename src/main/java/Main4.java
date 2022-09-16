import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i+m-1 < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j <= i+m-1; j++) {
                min = Math.min(min, nums[j]);
                if(min <= 0)
                    break;
            }
            if(min > 0){
                for (int j = i; j <= i+m-1; j++) {
                    nums[j] -= min;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += nums[i];
        }
        System.out.println(ans);
    }
}
