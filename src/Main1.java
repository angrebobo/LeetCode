import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:08 2021/10/31
 */
public class Main1 {

    public static int cal(int[] a, int[] b, int n){
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        List<List<Integer>> arrange = permute(nums);
        int max = 0;
        for(List<Integer> list : arrange){
            max = Math.max( max, calculate(list, a, b) );
        }
        return max;
    }

    public static List<List<Integer>> permute(int[] nums) {
        int depth = 0;
        List<Integer> path = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        dfs(nums, depth, len, used, path, res);

        return res;
    }

    public static void dfs(int[] nums, int depth, int len, boolean[] used,
                           List<Integer> path, List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth+1, len, used, path, res);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static int calculate(List<Integer> list, int[] a, int[] b){
        int hurt = 0;
        int len = list.size();
        if(len == 0) return 0;

        if( b[list.get(0)-1] > len){
            return 0;
        }
        else {
            hurt += a[list.get(0)-1];
            int temp = b[list.get(0)-1];
            for (int j = 1; j <= temp; j++) {
                list.remove(0);
            }
        }

        hurt += calculate(list, a, b);

        return hurt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] b = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        System.out.println(cal(a, b, n));
    }
}
