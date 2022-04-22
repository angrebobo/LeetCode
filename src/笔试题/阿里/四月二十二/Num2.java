package 笔试题.阿里.四月二十二;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:00 2022/4/22
 */
public class Num2 {
    //判断日期
    public static boolean isRight(String str){
        boolean result = true;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(str);
        } catch (ParseException e) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String query;
        HashMap<String, List<String>> map = new HashMap<>();
        HashMap<String, String> map1 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            query = sc.nextLine();
            String[] arr = query.split(" ");
            if("1".equals(arr[0])){
                String q = arr[1] + "-" + arr[2] + "-" + arr[3];
                if(isRight(q)){
                    if(map.containsKey(q)){
                        boolean flag = true;
                        for(String s : map.get(q)){
                            if(arr[4].equals(s)){
                                flag = false;
                                break;
                            }
                        }
                        if(!flag){
                            System.out.println("existed");
                        }
                        else {
                            List<String> list = map.get(q);
                            list.add(arr[4]);
                            map.put(q, list);
                            System.out.println("done");
                        }
                    }
                    else {
                        List<String> list = new LinkedList<>();
                        list.add(arr[4]);
                        map.put(q, list);
                        System.out.println("done");
                    }

                    map1.put(arr[4], q);
                }
                else
                    System.out.println("error");
            }
            else if("2".equals(arr[0])){
                String q = arr[1] + "-" + arr[2] + "-" + arr[3];
                if(map.containsKey(q))
                    System.out.println(map.get(q).size());
                else
                    System.out.println("0");
            }
            else if("3".equals(arr[0])){
                if(!map1.containsKey(arr[1]))
                    System.out.println("not existed");
                else {
                    String data = map1.get(arr[1]);
                    String[] temp = data.split("-");
                    StringBuffer s = new StringBuffer();
                    for(String ss : temp){
                        s.append(ss).append("/");
                    }
                        s.deleteCharAt(s.length()-1);
                    System.out.println(s);
                }
            }
        }

    }
}
