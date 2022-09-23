package 笔试题.蔚来.九月二十三;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.substring(1, str.length()-1);

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character character = str.charAt(i);
            if(!map.containsKey(character)){
                map.put(character, i);
            }
        }
        List<String[]> list = new ArrayList<>();
        for (Character character : map.keySet()) {
            String[] temp = new String[]{String.valueOf(character), map.get(character)+""};
            list.add(temp);
        }
        list.sort(Comparator.comparingInt(o -> Integer.parseInt(o[1])));
        StringBuilder ans = new StringBuilder();
        for (String[] strings : list) {
            ans.append(strings[0]);
        }
        System.out.println(ans);
    }
}
