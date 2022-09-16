import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 0:41 2022/9/3
 */
public class Test {

    public static List<Character> count(int n){
        int[] nums = new int[26];
        nums[0] = 1;
        for (int i = 1; i < 26; i++) {
            nums[i] = nums[i-1]*2;
        }

        List<Character> list = new ArrayList<>();
        while (n > 0){
            int i;
            for (i = 0; i < nums.length && nums[i] <= n; i++) {
            }
            // 找到n一下最大的数
            int index = i-1;
            n -= nums[index];
            list.add((char) ('a' + index));
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Character> count = count(n);
        for (Character character : count) {
            System.out.print(character);
        }

    }
}
