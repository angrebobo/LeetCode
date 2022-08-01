package LeetCode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:22 2022/5/19
 */
public class Offer_Num07 {

    static class Solution {
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int len = preorder.length;
            map = new HashMap<>();
            for (int i = 0; i < len; i++)
                map.put(inorder[i], i);

            return build(preorder, inorder, 0, len-1, 0, len-1);
        }

        public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                              int inorder_left, int inorder_right){
            if(preorder_left > preorder_right)
                return null;

            int val = preorder[preorder_left];
            TreeNode root = new TreeNode(val);

            int index = map.get(val);
            int left_num = index - inorder_left;

            root.left = build(preorder, inorder, preorder_left+1, preorder_left+left_num, inorder_left, index-1);
            root.right = build(preorder, inorder, preorder_left+left_num+1, preorder_right, index+1, inorder_right);

            return root;
        }

        //层序遍历打印树
        public void levelOrder(TreeNode root) {
            if(root == null)
                return;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()){
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    TreeNode temp = queue.poll();
                    System.out.print(temp.val + " ");
                    if(temp.left != null)
                        queue.add(temp.left);
                    if(temp.right != null)
                        queue.add(temp.right);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(preorder, inorder);
        solution.levelOrder(root);
    }
}
