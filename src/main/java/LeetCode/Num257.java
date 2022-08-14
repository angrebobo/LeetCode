package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Num257 {

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();

            path(root, "", list);
            return list;
        }

        public void path(TreeNode root, String builder, List<String> list){
            if(root == null)
                return;
            if(root.left==null && root.right==null){
                list.add(builder+root.val);
                return;
            }


            path(root.left, builder+root.val+"->", list);
            path(root.right, builder+root.val+"->", list);
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.right = n5;

        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(n1).toString());
    }
}
