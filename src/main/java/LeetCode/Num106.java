package LeetCode;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 17:14 2022/4/13
 */
public class Num106 {
    static class Solution {
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap<>();
            int n = inorder.length;
            //记录中序节点的位置
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return build(inorder, postorder, 0, n-1, 0, n-1);
        }

        public TreeNode build(int[] inorder, int[] postorder, int inorder_left, int inorder_right, int
                postorder_left, int postorder_right){
            if(inorder_left > inorder_right)
                return null;

            int root_val = postorder[postorder_right];
            TreeNode root = new TreeNode(root_val);

            //根节点在中序遍历中的位置
            int position = map.get(root_val);
            int leftTreeLength = position - inorder_left;

            root.left = build(inorder, postorder, inorder_left, position-1, postorder_left, postorder_left+leftTreeLength-1);
            root.right = build(inorder, postorder, position+1, inorder_right, postorder_left+leftTreeLength, postorder_right-1);

            return root;
        }
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        Solution solution = new Solution();
        Utils.show( solution.buildTree(inorder, postorder) );
    }
}
