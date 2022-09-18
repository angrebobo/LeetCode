package 笔试题.字节.九月十八;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:48 2022/9/18
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                temp.add(sc.nextInt());
            }
            list.add(temp);
        }

        int ans = 0;
        ans += list.get(0).size();
        for (int i = 1; i < n; i++) {
            List<Integer> deleteIndex = new ArrayList<>();
            for (int j = 0; j < list.get(i).size(); j++) {
                int num = list.get(i).get(j);
                //下一层为空，这一层全删掉
                if(list.get(i-1).size() == 0){
                    deleteIndex.addAll(list.get(i));
                }
                else {
                    //去下一层找到第一个比num大的数
                    int index = 0;
                    while (index < list.get(i-1).size() && list.get(i-1).get(index) <= num){
                        index++;
                    }

                    boolean flag = false;
                    if(index<list.get(i-1).size() && num+50>list.get(i-1).get(index)){
                        flag = true;
                    }
                    else if(index-1>=0 && num+50<list.get(i-1).get(index-1)+100){
                        flag = true;
                    }
                    else if(index<list.get(i-1).size() && index-1>=0 && num<list.get(i-1).get(index-1)+100 && num+100>list.get(i-1).get(index)){
                        flag = true;
                    }

                    if(!flag){
                        deleteIndex.add(num);
                    }
                }
            }

            // 把失效的块删掉
            for (Integer index : deleteIndex) {
                list.get(i).remove(index);
            }
            ans += list.get(i).size();
        }
        System.out.println(ans);
    }
}
