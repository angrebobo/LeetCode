package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:13 2022/4/17
 */
public class Num235 {

    static class TreeNode {
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

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> p_path = findPath(root, p);
            List<TreeNode> q_path = findPath(root, q);
            for (int i = p_path.size()-1; i >= 0; i--) {
                for (int j = q_path.size()-1; j >= 0; j--) {
                    if(p_path.get(i) == q_path.get(j))
                        return p_path.get(i);
                }
            }

            return new TreeNode();
        }

        public List<TreeNode> findPath(TreeNode root, TreeNode node){
            TreeNode p = root;
            List<TreeNode> path = new LinkedList<>();
            while (p.val != node.val){
                path.add(p);

                if(p.val < node.val)
                    p = p.right;
                else
                    p = p.left;
            }
            path.add(p);

            return path;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node1;node2.right = node4;
        node4.left = node3;node4.right = node5;

        Solution solution = new Solution();
        TreeNode ancestor = solution.lowestCommonAncestor(node2, node2, node3);
        System.out.println(ancestor.val);
    }
}
