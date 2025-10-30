package NewLeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 字母异位词分组
 */
public class Num49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortStr = Arrays.toString(charArray);
            if (map.containsKey(sortStr)) {
                map.get(sortStr).add(str);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(str);
                map.put(sortStr, temp);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"a"};
        System.out.println(new Num49().groupAnagrams(strs));
    }
}
