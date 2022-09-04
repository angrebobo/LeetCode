package 笔试题.京东;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:30 2022/9/3
 */
public class Main1 {

    static int min = Integer.MAX_VALUE;
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

//        List<int[]> ans = getSon(10);
//        for (int[] ints : ans) {
//            System.out.println(ints[0] + " " + ints[1]);
//        }

    }
}
