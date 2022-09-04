package 笔试题.京东;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:29 2022/9/3
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 1)
            System.out.println(0);
        else {
            sc.nextLine();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if(map.containsKey(temp))
                    map.put(temp, map.get(temp)+1);
                else
                    map.put(temp, 1);
            }

            List<int[]> list = new ArrayList<>();
            for (Integer integer : map.keySet()) {
                list.add(new int[]{integer, map.get(integer)});
            }
            list.sort((o1, o2) -> o2[0] - o1[0]);
            int ans = 0;
            for (int i = 1; i < list.size(); i++) {
                ans += list.get(i)[1];
            }
            System.out.println(ans);
        }
    }
}
