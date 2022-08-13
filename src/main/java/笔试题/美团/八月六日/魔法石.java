package 笔试题.美团.八月六日;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * 小美有n个魔法石，每个魔法石有正反两个数字，一开始全部正面朝上，
 * 魔法石要激活需要有一半以上的魔法石数字相同，
 * 问你把魔法石激活的最小翻牌次数（把魔法石从正面变反面）
 *
 * 每个魔法石有两面，分为正面和反面，正面有一个数字，反面有一个数字。
 * 然后一开始魔法石全部正面朝上。魔法石要激活，
 * 要魔法石中有相同数字的魔法石数量超过一半才可以。
 * 然后你可以对魔法石进行翻面，问最少翻多少次能激活魔法石。
 * 输入：
 * 5
 * 1 2 5 5 5
 * 1 1 9 3 1
 * 5
 * 1 2 4 5 6
 * 2 3 1 1 1
 *
 * 第一行为数组长度 最大100000
 * 第二行为正面的魔法石种类
 * 第二行为反面的魔法石种类
 * @Data: Created in 18:58 2022/8/12
 */
public class 魔法石 {

    public static int calculate(int[] a1, int[] a2){
        int len = a1.length;
        HashMap<Integer, Integer> up = new HashMap<>();
        HashMap<Integer, Integer> all = new HashMap<>();
        for (int i = 0; i < len; i++) {
            all.put(a1[i], all.getOrDefault(a1[i], 0) + 1);
            //正反面相同只记一次
            if(a1[i]!=a2[i]){
                all.put(a2[i], all.getOrDefault(a2[i], 0) + 1);
            }
            up.put(a1[i], up.getOrDefault(a1[i], 0) + 1);
        }

        int target = (len%2==0)?(len/2):(len/2 + 1);
        int min = len+1;
        for(int key : all.keySet()){
            if(all.getOrDefault(key, 0) >= target){
                if(up.getOrDefault(key, 0) >= target)
                    return 0;

                // 错误写法：min = Math.min(min, all.get(key)-up.getOrDefault(key,0));
                min = Math.min(min, target-up.getOrDefault(key,0));
            }
        }

        return min==len+1 ? -1 : min;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{1,1,8,5,6};
        int[] a2 = new int[]{2,1,1,0,1};
        System.out.println(calculate(a1, a2));
    }
}
