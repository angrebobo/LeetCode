import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

    static boolean flag;
    public static void dfs(int[][] grid, int point, StringBuilder builder,int red, int green, int blue, boolean[] visited){

        switch (builder.charAt(point)){
            case 'r':
                red+=1;
                break;
            case 'g':
                green+=1;
                break;
            case 'b':
                blue+=1;
                break;
        }

        if(red>=1 & green>=1 && blue>=1){
            flag = true;
            return;
        }

        for (int i = 1; i < grid[point].length; i++) {
            if(grid[point][i] == 1 && !visited[i]){
                visited[i] = true;
                dfs(grid, i, builder, red, green, blue, visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        StringBuilder builder = new StringBuilder().append(" ").append(s);
        int[][] grid = new int[n+1][n+1];
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n-1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            grid[a][b] = grid[b][a] = 1;
            list.add(new int[]{a,b});
        }

        int ans = 0;
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < n-1; i++) {
            int[] temp = list.get(i);
            grid[temp[0]][temp[1]] = grid[temp[1]][temp[0]] = 0;
            flag = false;
            visited[temp[0]] = true;
            dfs(grid, temp[0], builder,0,0,0, visited);
            visited[temp[0]] = false;
            if(flag){
                flag = false;
                visited[temp[1]] = true;
                dfs(grid, temp[1], builder,0,0,0, visited);
                visited[temp[1]] = false;

                if(flag)
                    ans++;
            }

            grid[temp[0]][temp[1]] = grid[temp[1]][temp[0]] = 1;
        }
        System.out.println(ans);
    }
}
