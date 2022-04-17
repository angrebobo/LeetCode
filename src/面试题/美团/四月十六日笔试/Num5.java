package 面试题.美团.四月十六日笔试;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 给一棵树，用双亲节点表示法存储在数组中
 * 现在要求能够计算任意两个节点之间的路径，并且对路径节点的值做异或操作
 */
public class Num5 {

    public static List<Integer> rootPath(int[] father, int node){
        List<Integer> list = new LinkedList<>();
        while (node != 0){
            list.add(node);
            node = father[node];
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

        //测试输入3 1 1 3 4 5 3 1 1 2 2 3 3

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

        int ans = 0;
        for (int k = 0; k < m; k++) {
            boolean flag = false;
            List<Integer> path1 = rootPath(father, query1[k]);
            List<Integer> path2 = rootPath(father, query2[k]);
            for (int i = 0; i < path1.size(); i++) {
                for (int j = 0; j < path2.size(); j++) {
                    //一次查询只需要计算一次结果
                    if(flag)
                        continue;
                    if(path1.get(i) == path2.get(j)){
                        //path1.get(i)这个元素是query1[k]和query2[k]的最近公共祖先
                        ans = value[path1.get(i)];
                        i--;
                        while (i >= 0){
                            ans ^= value[path1.get(i)];
                            i--;
                        }
                        j--;
                        while (j >= 0){
                            ans ^= value[path2.get(j)];
                            j--;
                        }
                        System.out.println(ans);
                        flag = true;
                    }
                }
            }
        }
    }
}


