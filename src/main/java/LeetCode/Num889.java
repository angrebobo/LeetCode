package LeetCode;

import java.util.HashMap;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 20:54 2022/8/1
 */
public class Num889 {
    static class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            // map保存节点在后序遍历里的索引位置
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < preorder.length; i++){
                for(int j = 0; j < postorder.length; j++){
                    if(preorder[i] == postorder[j])
                        map.put(preorder[i], j);
                }
            }

            return build(preorder, postorder, 0, preorder.length-1, 0, postorder.length-1, map);
        }

        public TreeNode build(int[] preorder, int[] postorder, int pre_left, int pre_right, int post_left, int post_right, HashMap<Integer, Integer> map){
            if(pre_left > pre_right)
                return null;

            TreeNode root = new TreeNode(preorder[pre_left]);
            if(pre_left == pre_right)
                return root;

            // 找到root的左子树的根节点 在 后序遍历中的下标，就能得出root的左子树的长度
            int index = map.get(preorder[pre_left+1]);
            int len = index - post_left + 1;

            root.left = build(preorder, postorder, pre_left+1, pre_left+len, post_left, post_left+len-1, map);
            root.right = build(preorder, postorder, pre_left+len+1, pre_right, post_left+len, post_right-1, map);

            return root;
        }
    }

    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        Solution solution = new Solution();
        TreeNode treeNode = solution.constructFromPrePost(preorder, postorder);
        Utils.show(treeNode);
    }
}
