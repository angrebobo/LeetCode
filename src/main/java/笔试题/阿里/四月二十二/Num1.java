package 笔试题.阿里.四月二十二;

import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 10:26 2022/4/22
 */
public class Num1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] ground = new char[n][m];
        String demand;
        int ans = 0;
        //记录虫子的初始位置
        int row = 0,col = 0;
        for (int i = 0; i < n; i++) {
            String temp = sc.next();
            for (int j = 0; j < m; j++) {
                ground[i][j] = temp.charAt(j);
                if(ground[i][j] == '*'){
                    row = i;
                    col = j;
                }
            }
        }
        demand = sc.next();
        int len = demand.length();
        for (int i = 0; i < len; i++) {
            int toRow;
            int toCol;
            if(demand.charAt(i) == 'W'){
                toRow = row-1;
                toCol = col;
            }
            else if(demand.charAt(i) == 'A'){
                toRow = row;
                toCol = col-1;
            }
            else if(demand.charAt(i) == 'S'){
                toRow = row+1;
                toCol = col;
            }
            else {
                toRow = row;
                toCol = col+1;
            }

            if(toRow<0 || toRow>n-1 || toCol<0 || toCol>m-1){
                continue;
            }
            if(ground[toRow][toCol] == '$'){
                ans++;
                ground[toRow][toCol] = '.';
            }


            row = toRow;
            col = toCol;
        }

        System.out.println(ans);
    }
}
