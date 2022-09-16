package 笔试题.蚂蚁;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:27 2022/9/15
 */
public class Test2 {

    static HashMap<String, Boolean> map1 = new HashMap<>();

    public static boolean count(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        if(map1.containsKey(Arrays.toString(chars)))
            return map1.get(Arrays.toString(chars));

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : chars) {
            if(map.containsKey(c))
                map.put(c, map.get(c)+1);
            else
                map.put(c, 1);
        }
        int odd = 0;
        for (Integer value : map.values()) {
            if(value % 2 != 0){
                odd++;
                if(odd > 1){
                    map1.put(s, false);
                    return false;
                }
            }
        }

        if(odd == 1){
            map1.put(s, true);
            return true;
        }
        else {
            map1.put(s, false);
            return false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int len = s.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j <= len; j++) {
                String s1 = s.substring(i, j);
                if( count(s1) )
                    ans++;
            }
        }
        System.out.println(ans);
    }
}
