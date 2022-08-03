package 笔试题.腾讯;

import java.util.*;
/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:17 2022/4/24
 */
public class Num2 {

    static public class Solution {
        /**
         * @param a int整型一维数组
         * @return int整型
         */
        public int getNumber (int[] a) {
           int len = a.length;
           boolean[] isPrime = new boolean[len+1];
           Arrays.fill(isPrime, true);
           for (int i = 2; i * i < len+1; i++) {
               if (isPrime[i]) {
                   for (int j = i * i; j < len+1; j+=i) {
                       isPrime[j] = false;
                   }
               }
           }
           //0,1不是质数
           isPrime[0] = false;
           isPrime[1] = false;

           int ans;

            List<Integer> list = new LinkedList<>();
            for(int i : a)
                list.add(i);

            while (true){
                List<Integer> temp = new LinkedList<>();
                int count = list.size();
                for (int i = 0; i < list.size(); i++) {
                    if(!isPrime[i+1]){
                        if(1 == --count){
                            temp.add(list.get(i+1));
                            break;
                        }
                    }
                    else {
                        temp.add(list.get(i));
                    }
                }
                list.clear();
                list.addAll(temp);
                if(list.size() == 1){
                    ans = list.get(0);
                    break;
                }
            }

            return ans;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3,1,1,4,5,6};
        Solution solution = new Solution();
        System.out.println(solution.getNumber(nums));
    }
}
