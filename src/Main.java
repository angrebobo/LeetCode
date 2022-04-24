import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:04 2022/4/24
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        int len = strs[0].length();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            String temp = "";
            for (int j = 0; j < n; j++) {
                temp += strs[j].charAt(i);
            }
            nums[i] = Integer.parseInt(temp);
        }
        Arrays.sort(nums);
        for(int a : nums)
            System.out.printf(a + " ");
    }
}
