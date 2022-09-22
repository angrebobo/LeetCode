package 笔试题.荣耀笔试;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * 过了100%
 * @Data: Created in 17:58 2022/9/22
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // map1记录歌曲名和分值
        HashMap<String, Integer> map1 = new HashMap<>();
        // map2记录类别和对应的歌曲名
        HashMap<String, List<String>> map2 = new HashMap<>();
        // map3记录歌曲名和对应的信息
        // map3同时记录上一条P和B信息
        HashMap<String, String[]> map3 = new HashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            // 导入歌曲
            if ("I".equals(split[0])) {
                map1.put(split[1], 0);
                if (!map2.containsKey(split[2])) {
                    List<String> temp = new ArrayList<>();
                    temp.add(split[1]);
                    map2.put(split[2], temp);
                } else {
                    map2.get(split[2]).add(split[1]);
                }
                map3.put(split[1], split);
            }
            // 播放歌曲
            else if ("P".equals(split[0])) {
                map1.put(split[1], map1.get(split[1]) + 3);

                String variety = map3.get(split[1])[2];
                if (map3.containsKey("P")) {
                    if (!Objects.equals(variety, "UnkownStyle") &&
                            variety.equals(map3.get("P")[1])) {
                        for (String s1 : map2.get(variety)) {
                            if (!s1.equals(split[1])) {
                                map1.put(s1, map1.get(s1) + 1);
                            }
                        }
                    }
                }
                split[1] = variety;
                map3.put("P", split);
            } else if ("B".equals(split[0])) {
                map1.put(split[1], map1.get(split[1]) - 2);

                String variety = map3.get(split[1])[2];
                if (map3.containsKey("B")) {
                    if (!Objects.equals(variety, "UnkownStyle") &&
                            variety.equals(map3.get("B")[1])) {
                        for (String s1 : map2.get(variety)) {
                            if (!s1.equals(split[1])) {
                                map1.put(s1, map1.get(s1) - 1);
                            }
                        }
                    }
                }
                split[1] = variety;
                map3.put("B", split);
            }
        }

        List<String[]> list = new ArrayList<>();
        for (String s : map1.keySet()) {
            String[] temp = map3.get(s);
            temp[0] = map1.get(s)+"";
            list.add(temp);
        }
        // 排序
        list.sort((o1, o2) -> {
            if(!Objects.equals(o1[0], o2[0])){
                // 分值从大到小
                return Integer.parseInt(o2[0]) - Integer.parseInt(o1[0]);
            }
            else {
                // 字典序排序
                return o1[1].compareTo(o2[1]);
            }
        });

        for (String[] strings : list) {
            System.out.println(strings[1] + " " + strings[2]);
        }
    }
}
