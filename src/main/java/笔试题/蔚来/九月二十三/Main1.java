package 笔试题.蔚来.九月二十三;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(i+2<n && !visited[i] && !visited[i+1] && !visited[i+2] && scores[i+2]-scores[i]<=10){
                count++;
                visited[i] = true;
                visited[i+1] = true;
                visited[i+2] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if(i+1<n && !visited[i] && !visited[i+1] && scores[i+1]-scores[i+2]<=20){
                count++;
                visited[i] = true;
                visited[i+1] = true;
            }
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                count++;
                visited[i] = true;
            }
        }
        System.out.println(count);
    }
}
