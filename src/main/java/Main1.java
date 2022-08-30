import java.util.Scanner;

public class Main1 {

    public static int calculate(int n){
        if(n % 2 == 0)
            return n;

        // 判断n中是否有偶数
        boolean flag = false;
        int index = -1;
        String s = n+"";
        char[] chars = s.toCharArray();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int temp = chars[i] - '0';
            if(temp%2 == 0){
                flag = true;
                index  = i;
                break;
            }
        }
        if(!flag)
            return -1;


        char temp = chars[len-1];
        chars[len-1] = chars[index];
        chars[index] = temp;
        int ans = 0;
        for (int i = 0; i <len ; i++) {
            ans *= 10;
            ans += chars[i]-'0';
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        int[] nums = new int[q];
        for (int i = 0; i < q; i++) {
            nums[i] = sc.nextInt();
            System.out.println( calculate(nums[i]) );
        }
    }
}
