package 笔试题.小米;

import LeetCode.TreeNode;

import java.util.*;

/**
 * 已知一颗完全二叉树，有N个节点 求最后一个节点
 * https://github.com/Xiangyaojun/Algorithms/blob/master/%E4%BA%8C%E5%8F%89%E6%A0%91/%E5%AE%8C%E5%85%A8%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E5%90%8E%E4%B8%80%E4%B8%AA%E8%8A%82%E7%82%B9.py
 *
 */
public class 完全二叉树的最后一个节点 {

    // 方法1，层序遍历
   /* public static TreeNode findLast(TreeNode root){
        List<TreeNode> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            list.clear();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = queue.poll();
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                list.add(temp);
            }
        }
        return list.get(list.size()-1);
    }*/

    /**
     * 方法2，用完全二叉树的性质
     * 根节点的下标为i，左孩子的下标为2i，右孩子下标为2i+1
     * 比如知道完全二叉树的节点有6个，如下：
     *            1
     *          /   \
     *         2     3
     *       /  \   /
     *      4    5  6
     * 最下一层最右边的节点为6
     * 将6不断除2，记录下来，[6,3]
     * 6是偶数，回到父节点走左边；3是奇数，回到父节点走右边
     * 所以倒序遍历[6,3]，从root出发，碰到奇数走右边，碰到偶数走左边
     */
    public static TreeNode findLast(TreeNode root, int N){
        if(N <= 1)
            return root;

        List<Integer> list = new ArrayList<>();
        while (N > 1){
            list.add(N);
            N /= 2;
        }

        TreeNode node = root;
        for (int i = list.size()-1; i >= 0; i--) {
            if(list.get(i) % 2 == 0)
                node = node.left;
            else
                node = node.right;
        }
        return node;
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;
        n3.left = n6;

        System.out.println(findLast(n1,6).val);
    }
}
