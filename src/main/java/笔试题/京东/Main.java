package 笔试题.京东;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * 题目：找出赝品
 * 题目描述：小红拿到了n个物品，每个物品的品质为ai。这n个物品中至少有一个真品。
 * 已知所有真品的品质都是相同的，但赝品的品质比真品低。小红想知道，这n个物品中最多有多少赝品。
 * 输入描述：第一行输入一个正整数n，代表小红拿到的物品数量。第二行输入n个正整数ai，代表每个物品的品质。n≤1e5, ai ≤ 1e9
 * 输出描述：一个整数，代表赝品的数量
 *
 * input：
 * 1
 * 5
 * output：
 * 0
 *
 * 思路：品质最高的为正品，其余都是赝品
 * @Data: Created in 19:29 2022/9/3
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            // 品质最高的为正品
            maxVal = Math.max(maxVal, temp);
            if(map.containsKey(temp))
                map.put(temp, map.get(temp)+1);
            else
                map.put(temp, 1);
        }

        int ans = 0;
        for (Integer key : map.keySet()) {
            if(key != maxVal)
                ans += map.get(key);
        }
        System.out.println(ans);
    }
}
