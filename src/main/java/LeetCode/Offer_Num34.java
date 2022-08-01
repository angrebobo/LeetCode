package LeetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:28 2022/4/14
 */
public class Offer_Num34 {

    static class Solution {
        List<List<Integer>> res;
        List<Integer> path;

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            res = new LinkedList<>();
            path = new LinkedList<>();
            dfs(root, target);

            return res;
        }

        public void dfs(TreeNode node, int target){
            if(node == null)
                return ;
            path.add(node.val);
            target -= node.val;
            if(target==0 && node.left==null && node.right==null){
                res.add( new LinkedList<>(path) );
            }

            dfs(node.left, target);
            dfs(node.right, target);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(5);
        TreeNode n10 = new TreeNode(1);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n3.left = n5;n3.right = n6;
        n4.left = n7;n4.right = n8;n6.left = n9;n6.right = n10;

        Solution solution = new Solution();
        solution.pathSum(n1, 22);
    }
}
