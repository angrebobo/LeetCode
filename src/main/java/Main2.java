import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:45 2022/9/21
 */
public class Main2 {

    static int maxVal;
    public static int calculate(int n, int[] position, int[] radius, int[] value){
        maxVal = 0;
        int[] visited = new int[n];
        dfs(0, n, position, radius, value, visited, 0);
        return maxVal;
    }

    public static void dfs(int index, int n, int[] position, int[] radius, int[] value, int[] visited, int curVal){
        // 有重叠区域
        if(!check(position, radius, visited)){
            return;
        }
        maxVal = Math.max(maxVal, curVal);
        if(index == n)
            return;


        dfs(index+1, n, position, radius, value, visited, curVal);

        visited[index] = 1;
        dfs(index+1, n, position, radius, value, visited, curVal+value[index]);
        visited[index] = 0;
    }

    public static boolean check(int[] position, int[] radius, int[] visited){
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < visited.length; i++) {
            if(visited[i] == 1){
                list.add(new int[]{position[i]-radius[i], position[i]+radius[i]});
            }
        }

        list.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i)[0] < list.get(i-1)[1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] position = new int[n];
        for (int i = 0; i < n; i++) {
            position[i] = sc.nextInt();
        }
        int[] radius = new int[n];
        for (int i = 0; i < n; i++) {
            radius[i] = sc.nextInt();
        }
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        System.out.println(calculate(n, position, radius, value));
    }
}
//4
//2 3 4 5
//1 1 1 2
//50 10 40 70

//5
//2 3 6 5 7
//1 1 3 1 1
//20 20 100 70 60