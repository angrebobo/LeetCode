package LeetCode;

import java.util.*;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:05 2021/10/12
 */
public class Num10 {

    static class DTO{
        private String word;
        private int num;
        public DTO(String word, int num) {
            this.word = word;
            this.num = num;
        }
    }

    static Map<String, Integer> fun1(String str){
        String[] strs = str.split(" ");
        Map<String, Integer> res = new HashMap<>();
        
        for(String s : strs){
            if(res.containsKey(s)){
                res.put(s, res.get(s)+1);
            }
            else {
                res.put(s, 1);
            }
        }
        
        return res;
    }

    static List<DTO> fun2(Map<String, Integer> map){
        List<DTO> res = new ArrayList<>();

        for (String s : map.keySet()) {
            res.add( new DTO(s, map.get(s)) );
        }

        Collections.sort(res, (o1, o2) -> o2.num-o1.num);

        return res;
    }


    public static void main(String[] args) {
        String str = "aaa bbb ccc aaa ccc ddd";
        Map<String, Integer> res = fun1(str);
        List<DTO> dtos = fun2(res);

    }

}
