package 笔试题.京东;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：小红的元素分裂
 * 小红拿到了一个数组，她每次可以进行如下操作之一：
 * 1、选择一个元素x，将其分裂为1和x-1。
 * 2、选择一个元素x，将其分裂为a和b，需要保证a*b=x
 * 小红希望用最少的操作次数，将所有数组的所有元素全部变成1。你能帮帮她吗？
 * 输入描述
 * 第一行输入一个正整数n，代表数组的长度。第二行输入n个正整数ai，代表小红拿到的数组。1 ≤ n, ai ≤ 1e5
 * 2
 * 2 6
 * 输出描述
 * 一个整数，代表最小的操作次数。
 * 5
 * @Data: Created in 19:30 2022/9/3
 */
public class Main1 {


    // 这是笔试的时候我自己写的，没有记忆化，时间复杂度太高了,写的和屎一样
    /*static int min = Integer.MAX_VALUE;
    static HashMap<Integer, List<int[]>> map = new HashMap<>();
    public static void dfs(List<Integer> list, int count){
        if(count > min)
            return;
        if( check(list) ){
            min = Math.min(count, min);
            return;
        }


        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) != 1){
                int num = list.get(i);

                List<int[]> son;
                // 分解成因数
                if(map.containsKey(num))
                    son = map.get(num);
                else {
                    son = getSon(num);
                    map.put(num, son);
                }
                for (int[] ints : son) {
                    list.set(i, ints[0]);
                    list.add(i + 1, ints[1]);
                    dfs(list, count + 1);
                    list.remove(i + 1);
                    list.set(i, num);
                }


                // 分解成1和x-1
                list.set(i, 1);
                list.add(i+1, num-1);
                dfs(list, count+1);
                list.remove(i+1);
                list.set(i, num);
            }
        }
    }

    // 获取因数
    public static List<int[]> getSon(int n){
        List<int[]> list = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if(n%i == 0){
                if(list.size() == 0)
                    list.add(new int[]{i, n/i});
                else {
                    if(i >= list.get(list.size()-1)[1])
                        break;
                    else
                        list.add(new int[]{i, n/i});
                }
            }
        }

        return list;
    }

    public static boolean check(List<Integer> list){
        for (Integer integer : list) {
            if(integer != 1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( sc.nextInt() );
        }
        dfs(list, 0);
        System.out.println(min);
    }*/


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max+1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j = 2; j <= Math.sqrt(i) && i%j == 0; j++) {
                dp[i] = Math.min(dp[i], dp[j] + dp[i/j] + 1);
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[nums[i]];
        }
        System.out.println(ans);
    }
}
