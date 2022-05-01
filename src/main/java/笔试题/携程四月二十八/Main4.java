package 笔试题.携程四月二十八;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:45 2022/4/28
 */
public class Main4 {

    static int[] nums;
    static int maxZero = Integer.MIN_VALUE;
    public static void dfs(int n, int index, boolean isGet){
        if(index == nums.length){
            maxZero = Math.max(count(n), maxZero);
            return;
        }
        maxZero = Math.max(count(n), maxZero);

        dfs(n, index+1, false);

        if(index==0 || (index>0 && !isGet)){
            dfs(n*nums[index], index+1, true);
        }
    }

    //计算num末尾有几个0
    public static int count(int num){
        int numOfZero;
        /*while (num%10 == 0){
            numOfZero++;
            num /= 10;
        }*/
        for (numOfZero = 0; num%10 == 0; numOfZero++,num/=10) {
        }
        return numOfZero;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        dfs(1,0, false);
        System.out.println(maxZero);
    }
}
