package 面试题.美团.四月十六日笔试;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给一棵树，用双亲节点表示法存储在数组中
 * 现在要求能够计算任意两个节点之间的路径，并且对路径节点的值做异或操作
 */
public class Num5 {

    public static List<Integer> findRoot(int[] father, int node){
        List<Integer> list = new LinkedList<>();
        list.add(node);
        while (node != 0){
            node = father[node];
            list.add(node);
        }
        return list;
    }


    /**
     * 输入格式：
     * 先给一个n值，表示树的节点数
     * 再给一个长度为n-1的数组，下标i的值j表示j是i的父亲节点
     * 再给一个长度为n的数组，值为树节点的权值
     * 再给一个m，表示查询的次数
     * 再给两个数组，
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //树的节点个数
        int n = sc.nextInt();
        int[] father = new int[n+1];
        for (int i = 2; i <= n; i++) {
            father[i] = sc.nextInt();
        }
        int[] value = new int[n+1];
        for (int i = 1; i <= n; i++) {
            value[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] query1 = new int[m];
        int[] query2 = new int[m];
        for (int i = 0; i < m; i++) {
            query1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            query2[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            List<Integer> path1 = findRoot(father, query1[i]);
            List<Integer> path2 = findRoot(father, query2[i]);


        }


    }
}


