package 面试题.华为.四月二十日;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: HuangSiBo
 * @Description:
 *
 * 先给一颗根树，中序遍历存在数组中。空节点用0表示
 * 再给一条路径，这条路径在根树中一定能找到
 * 再给一颗子树，将根树中路径的最后一个节点及其子节点，替换成子树
 * 例如：输入
 * 1,1,2,0,0,4,5
 * /1/2
 * 4,5,0
 *
 * 根树：       1
 *            ↙ ↘
 *          1     2
 *              ↙   ↘
 *            4      5
 * 路劲：1 → 2
 *
 * 子树：      4
 *          ↙
 *         5
 *
 * 将根树中2节点及其子节点用子树替换
 * 输出：1,1,4,0,0,5
 *              1
 *             ↙ ↘
 *           1     4
 *               ↙
 *             5
 *
 * @Data: Created in 20:02 2022/4/20
 */
public class Num2 {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    //建树
    static TreeNode create(int[] nums, int index){
        if(nums.length == 0)
            return null;
        if(index >= nums.length || nums[index] == 0){
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = create(nums, index*2);
        root.right = create(nums, index*2+1);
        return root;
    }

    //层序打印
    static void sequencePrint(TreeNode p){
        StringBuffer s = new StringBuffer();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(p);
        while (!queue.isEmpty()){
            p = queue.poll();
            if(p.val == 0)
                s.append("0,");
            else{
                s.append(p.val).append(",");
                if(p.left!=null)
                    queue.add(p.left);
                if(p.left==null)
                    queue.add(new TreeNode(0));
                if(p.right!=null)
                    queue.add(p.right);
                if(p.right==null)
                    queue.add(new TreeNode(0));
            }
        }

        while (s.charAt(s.length()-1)=='0' || s.charAt(s.length()-1)==',')
            s.deleteCharAt(s.length()-1);

        System.out.println(s);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] fatherTree;
        String s;
        int[] sonTree;

        String str = sc.next();
        String[] temp = str.split(",");
        fatherTree = new int[temp.length+1];
        for (int i = 0; i < temp.length; i++) {
            fatherTree[i+1] = Integer.parseInt(temp[i]);
        }

        sc.nextLine();
        s = sc.nextLine();

        str = sc.next();
        temp = str.split(",");
        sonTree = new int[temp.length+1];
        for (int i = 0; i < temp.length; i++) {
            sonTree[i+1] = Integer.parseInt(temp[i]);
        }

        TreeNode father = create(fatherTree,1);
        TreeNode son = create(sonTree,1);
        temp = s.split("/");
        List<Integer> path = new LinkedList<>();
        for (int i = 1; i < temp.length; i++) {
            path.add(Integer.parseInt(temp[i]));
        }

        int index = 1;
        TreeNode p = father;
        //pre节点记录路径最后一个节点的父节点
        TreeNode pre = father;

        while (index != path.size()-1){
            if(index == path.size()-1)
                pre = p;
            if(p.left.val == path.get(index))
                p = p.left;
            else
                p = p.right;

            index++;
        }

        //将节点替换成子树
        if(pre.left.val == path.get(path.size()-1))
            pre.left = son;
        else
            pre.right = son;

        sequencePrint(father);
    }
}
