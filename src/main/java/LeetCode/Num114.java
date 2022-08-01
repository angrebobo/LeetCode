package LeetCode;

import java.util.LinkedList;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:19 2022/4/13
 */
public class Num114 {

    static class Solution {
        LinkedList<TreeNode> list = new LinkedList<>();

        public void flatten(TreeNode root) {
            dfs(root);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                list.get(i).left = null;
                if(i == size-1)
                    break;
                list.get(i).right = list.get(i+1);
            }
        }

        public void dfs(TreeNode root){
            if(root == null)
                return;

            list.add(root);
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        n1.left = n2;n1.right = n3;
        n2.left = n4;n2.right = n5;

        Solution solution = new Solution();
        solution.flatten(n1);
    }
}
