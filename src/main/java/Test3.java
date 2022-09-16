import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:10 2022/9/15
 */
public class Test3 {

    static int count = 0;
    static List<List<Integer>> nodeList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeNum = sc.nextInt();
        nodeList = new ArrayList<>();
        for (int i = 0; i <= nodeNum; i++) {
            nodeList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodeNum-1; i++) {
            int parent = sc.nextInt(), son = sc.nextInt();
            List<Integer> temp = nodeList.get(parent);
            temp.add(son);
        }
        dfs(nodeList.get(1),1);
        System.out.println(count);
    }

    public static void dfs(List<Integer> curList, int level){
        if(curList.isEmpty())
            return;
        for (Integer node : curList) {
            count+=node-level;
            dfs(nodeList.get(node), node);
        }

    }
}
