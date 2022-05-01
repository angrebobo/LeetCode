package 笔试题.美团.四月二十三日笔试;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 3.颜色排序
 * 题目描述：
 * 小美得到了一个长度为n的整数序列，并且序列上每个数字都被染上了颜色1~n的其中一种。
 * 现在小美想要给这个序列按从小到大排序，但她每次操作只能交换相邻两个数，并且这两个数的颜色要不相同。
 * 她想知道进行若干次操作之后能不能给这个序列排好序。
 * 输入描述
 * 第一行一个正整数T，表示有T组数据。
 * 对于每一组数据，第一行一个正整数n，表示这个序列的长度；第二行n个正整数ai，表示该序列；
 * 第三行n个正整数ci，表示第 i 个数的颜色。
 * 数字间两两有空格隔开
 * 1≤T≤8，1≤n≤104 ，1≤ai,ci≤n
 * 输出描述
 * 对于每一组数据，如果可以排好序，输出一行Yes；否则，输出一行No。
 * 样例输入
 * 2
 * 5
 * 3 2 4 1 5
 * 1 2 2 3 1
 * 3
 * 2 2 1
 * 1 1 1
 * 样例输出
 * Yes
 * No
 * 样例解释
 * 第一组样例可以如下排序：
 * [3 2 4 1 5] -> [2 3 4 1 5] -> [2 3 1 4 5] -> [2 1 3 4 5] -> [1 2 3 4 5]
 */
public class Num3 {

    public static boolean isOk(int n, int[] nums, int[] color){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], color[i]);
        }

        for(int i=0; i<n; i++){//表示n次排序过程。
            for(int j=1; j<n-i; j++){
                if(nums[j-1] > nums[j]){//前面的数字大于后面的数字就交换
                    if(map.get(nums[j-1]) == map.get(nums[j]))
                        return false;
                    int temp;
                    temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j]=temp;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int[] color = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                color[j] = sc.nextInt();
            }

            if(isOk(n, nums, color))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
