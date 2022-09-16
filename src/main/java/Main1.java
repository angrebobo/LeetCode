import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        long cur = 1;
        int index = 0;
        int[] count = new int[n];
        while (cur <= k){
            if(count[index] < nums[index]){
                if(cur == k){
                    System.out.println(index+1);
                }
                count[index]++;
                cur++;
            }
            index = (index+1)%(n);
        }
    }
}
