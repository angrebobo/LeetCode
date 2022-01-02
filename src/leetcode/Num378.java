package leetcode;

import java.util.PriorityQueue;


public class Num378 {
    public static void main(String []args){
        int[][] matrix = new int[][]{{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));

    }
    public static int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

}