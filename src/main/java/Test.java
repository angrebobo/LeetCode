import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 22:54 2022/9/17
 */
public class Test {
    static class people{
        int val;
        int index;
        public people(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static char[] calculate(List<people> list, int m){
        int len = list.size();
        char[] ans = new char[len];
        while (list.size() > 0){
            len = list.size();
            List<Integer> deleteIndex = new ArrayList<>();
            int index = findMax(list);
            ans[list.get(index).index] = 'A';
            deleteIndex.add(index);
            for (int i = 1; i <= m; i++) {
                if(index+i<len){
                    ans[list.get(index+i).index] = 'A';
                    deleteIndex.add(index+i);
                }
                if(index-i>=0){
                    ans[list.get(index-i).index] = 'A';
                    deleteIndex.add(index-i);
                }
            }
            deleteIndex.sort((o1, o2) -> o2-o1);
            for (Integer index1 : deleteIndex) {
                list.remove(index1.intValue());
            }

            if(list.size()>0){
                len = list.size();
                deleteIndex.clear();
                index = findMax(list);
                ans[list.get(index).index] = 'B';
                deleteIndex.add(index);
                for (int i = 1; i <= m; i++) {
                    if(index+i<len){
                        ans[list.get(index+i).index] = 'B';
                        deleteIndex.add(index+i);
                    }
                    if(index-i>=0){
                        ans[list.get(index-i).index] = 'B';
                        deleteIndex.add(index-i);
                    }
                }
                deleteIndex.sort((o1, o2) -> o2-o1);
                for (Integer index1 : deleteIndex) {
                    list.remove(index1.intValue());
                }
                deleteIndex.clear();
            }
        }

        return ans;
    }

    public static int findMax(List<people> list){
        int index = 0;
        int max = list.get(0).val;
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i).val > max){
                max = list.get(i).val;
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        List<people> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add( new people(sc.nextInt(), i) );
        }
        char[] chars = calculate(list, m);
        for (char c : chars) {
            System.out.print(c);
        }
    }
}
