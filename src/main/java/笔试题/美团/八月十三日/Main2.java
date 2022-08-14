package 笔试题.美团.八月十三日;

import java.util.Scanner;

/**
 * 打扫房间，有一个扫地机器人，位于房间room[0][0]的位置，且该地板已经打扫干净，给出一串指令，W向上，A向左，S向下，D向右，问该指令能否让机器人能否打扫干净n*m的房间；能，Yes 第几个指令后就已经打扫干净了（指令从1算起）；不能，No 还差几块地板没扫干净
 * 输入：
 * n m k(指令的个数)
 * 指令字符串
 */
public class Main2 {

    public static int mock(int n, int m , String code){
        boolean[][] visited = new boolean[n][m];
        int i = 0;
        int j = 0;
        visited[i][j] = true;
        int temp = 0;
        for (int k = 0; k < code.length(); k++) {
            char c = code.charAt(k);
            if(c == 'W'){
                i--;
            }
            else if(c == 'A'){
                j--;
            }
            else if(c == 'S'){
                i++;
            }
            else if(c == 'D'){
                j++;
            }
            visited[i][j] = true;
            temp = check(visited);
            //打扫干净了，返回
            if(temp == 0)
                return k+1;
        }

        //没打扫干净，返回负数
        return -temp;
    }

    //检查是否打扫干净，返回未打扫的区域
    public static int check(boolean[][] visited){
        int num = 0;
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if(!visited[i][j])
                    num++;
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String code = sc.nextLine();
        int mock = mock(n, m, code);
        if(mock>0){
            System.out.println("Yes");
            System.out.println(mock);
        }
        else {
            System.out.println("No");
            System.out.println(-mock);
        }


    }
}
