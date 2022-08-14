package 笔试题.美团.八月十三日;

import java.util.*;

/**
 * 扑克，把最顶层两张放到最下面，拿顶层的一张输出，直到所有的牌都被拿走，给出输出序列，还原原始序列
 */
public class Main3 {

    public static Deque<Integer> get(int n, Deque<Integer> list){
        if(n<=2){
            return list;
        }

        return  null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Deque<Integer> list = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }

        //Deque<Integer> ans = get(n, list);
        System.out.println(0);

    }
}
