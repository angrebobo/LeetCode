package LeetCode;

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

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        }

        public List<TreeNode> findPath(TreeNode root, TreeNode node){
            TreeNode p = root;
            List<TreeNode> path = new LinkedList<>();
            path.add(p);
            while (p != node){

            }
        }
    }

    public static void main(String[] args) {

    }
}
