package 笔试题.字节.九月十八;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:04 2022/9/18
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1, s.length()-1);
        if(s.length() == 0)
            System.out.println(0);
        else {
            String[] split = s.split(",");
            int[] nums = new int[split.length];
            for (int i = 0; i < split.length; i++) {
//                nums[i] = Long.parseLong(split[i]);
                nums[i] = Integer.parseInt(split[i].trim());
            }

            List<String> ans = new ArrayList<>();
            int index = 0;
            while (index < nums.length){
                String temp = nums[index] + "";
                int i = index;
                while (i+1 < nums.length && nums[i]+1==nums[i+1]){
                    i++;
                }
                if(i != index){
                    if(i >= index+2){
                        temp += "-" + nums[i];
                        ans.add(temp);
                    }
                    else {
                        for (int j = index; j <= i; j++) {
                            ans.add(nums[j]+"");
                        }
                    }
                }
                else {
                    ans.add(temp);
                }

                index = i+1;
            }
            String ss = String.join(",", ans);
            System.out.println(ss);
        }
    }
}
