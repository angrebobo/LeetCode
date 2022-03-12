import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description: 给定N个整数（可能有负数），从中选择K个数，使得这K个数之和恰好等于一个给定的整数target:
 * 如果有多种方案，选择它们中元素平方和最大的一个。数据保证这样的方案唯一。
 * @Data: Created in 22:01 2022/3/12
 */
public class DFS {
    static int[] N = new int[]{2,3,3,4};
    static int K = 2;
    static int target = 6;
    // 最大平方和为maxSqu
    static int maxSqu = 0;
    // temp为临时数组。用temp存放当前已经选择的整数。当试图进入“选第index个数”分支时，就把N[index]加入到temp中；
    // 而当该条分支结束时，就把它从temp中去除，使它不会影响“不选第index个数”这条分支。
    static List<Integer> temp = new LinkedList<>();
    // ans存放平方和最大的方案
    static List<Integer> ans = new LinkedList<>();

    //当前处理第index个元素，当前已选整数个数为noxK
    //当前已选整数之和为sum，当前已选整数之平方和为sumSqu
    static void dfs(int index, int noxK, int sum, int sumSqu){
        if(noxK==K && sum==target){
            if(sumSqu > maxSqu){
                maxSqu = sumSqu;
                ans = temp;
            }
            return;
        }
        //当前已选整数个数大于K，或者当前已选整数之大于target，或者已经处理了N个元素，返回
        if(noxK>K || sum>target || index==N.length)
            return;

        //选第index个数
        temp.add(N[index]);
        dfs(index+1, noxK+1, sum+N[index], sumSqu+N[index]*N[index]);
        temp.remove(temp.size()-1);

        //不选第index个数
        dfs(index+1, noxK, sum, sumSqu);
    }

    public static void main(String[] args) {
        dfs(0, 0, 0, 0);
        System.out.println(ans);
    }
}
