import java.util.*;
import java.util.Scanner;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] parent = new int[n+1];
            for (int i = 2; i <=n ; i++) {
                parent[i] = sc.nextInt();
            }
            int[] weight = new int[n+1];
            for(int i=1; i<=n; i++){
                weight[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] arr1 = new int[m];
            int[] arr2 = new int[m];
            for (int i = 0; i < m; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                arr2[i] = sc.nextInt();
            }

            for (int i = 0; i < m; i++) {
                int a = arr1[i];
                int b = arr2[i];
                int last = 1;
                LinkedList<Integer> pa = back2root(a, parent);
                LinkedList<Integer> pb = back2root(b, parent);
                while (!pa.isEmpty() && !pb.isEmpty() && Objects.equals(pa.peekLast(), pb.peekLast())){
                    last = pa.removeLast();
                    pb.removeLast();
                }
                int res = weight[last];
                while (!pa.isEmpty()){
                    res ^= weight[pa.removeLast()];
                }
                while (!pb.isEmpty()){
                    res ^= weight[pb.removeLast()];
                }
                System.out.print(res+" ");

            }

        }
    }
    static LinkedList<Integer>  back2root(int i, int[] parent){
        LinkedList<Integer> ans = new LinkedList<>();
        while (i!=0){
            ans.addLast(i);
            i = parent[i];
        }
        return ans;
    }

}
