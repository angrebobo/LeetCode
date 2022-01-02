package leetcode;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.time.temporal.Temporal;
import java.util.*;


/**
 * @desiption:
 * @author: HuangSiBo
 * @data: 2021/5/11 16:47
 */


public class Num103 {

    /*class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        List<Integer> temp = new LinkedList<>();
        int num =1;

        Queue<TreeNode> queue = new LinkedList<>();
        if(root != null){
            queue.add(root);
        }
        while (!queue.isEmpty()){
            int numOfLayer = 0;
            for (int i = 0; i < num; i++) {
                TreeNode treeNode = queue.poll();
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                    numOfLayer++;
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                    numOfLayer++;
                }
            }
            num = numOfLayer;
        }
        return  null;
    }*/



    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){};
        TreeNode(int val) { this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @Description 2021.09.21写
     * @param
     * @return
     */
    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int size;
            int n = 0;
            List<List<Integer>> ans = new ArrayList<>();

            while (!queue.isEmpty()){
                n++;
                size = queue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    temp.add(node.val);
                    if(node.left != null)
                        queue.add(node.left);
                    if(node.right != null)
                        queue.add(node.right);
                }
                if(n%2 == 0)
                    Collections.reverse(temp);

                ans.add(temp);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Solution solution = new Solution();
        System.out.println(solution.zigzagLevelOrder(node1));
    }
}

