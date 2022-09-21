package 笔试题.迅雷;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:29 2022/9/19
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            if(split[i].length()>0)
                list.add(split[i].trim());
        }
        int[] nums = new int[list.size()];
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            nums[i] = Integer.parseInt(list.get(i));
            sum += nums[i];
        }

        int average = sum/nums.length;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > average){
                int temp = nums[i]-average;
                nums[i] -= temp;
                nums[i+1] += temp;
                count++;
            }
            else if(nums[i] < average){
                int temp = average - nums[i];
                nums[i] += temp;
                nums[i+1] -= temp;
                count++;
            }
        }
        System.out.println(count);
    }
}
