package LeetCode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author didi
 * @Date 2022/2/13 18:25
 **/
public class Test {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(6);
        list.add(3);
        list.sort((o1,o2) -> o1-o2);
        System.out.println(list);
    }
}
