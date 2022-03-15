package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:03 2021/10/9
 */
public class Num105 {

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

    /*static class Solution {
        private Map<Integer, Integer> indexMap;

        public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
            if (preorder_left > preorder_right) {
                return null;
            }

            // 前序遍历中的第一个节点就是根节点
            int preorder_root = preorder_left;
            // 在中序遍历中定位根节点
            int inorder_root = indexMap.get(preorder[preorder_root]);

            // 先把根节点建立出来
            TreeNode root = new TreeNode(preorder[preorder_root]);
            // 得到左子树中的节点数目
            int size_left_subtree = inorder_root - inorder_left;
            // 递归地构造左子树，并连接到根节点
            // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
            root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
            // 递归地构造右子树，并连接到根节点
            // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
            root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
            return root;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            // 构造哈希映射，帮助我们快速定位根节点
            indexMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indexMap.put(inorder[i], i);
            }
            return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
        }
    }*/

    //2022.03.15日写
    static class Solution {
        HashMap<Integer, Integer> map = new HashMap<>();

        public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
            if(preorder_left > preorder_right)
                return null;

            //构造根节点
            int root = preorder[preorder_left];
            TreeNode node = new TreeNode(root);

            //定位当前根节点在中序排列中的位置
            int inorder_root = map.get(root);
            int sizeOfLeftTree = inorder_root - inorder_left;

            node.left = build(preorder, inorder, preorder_left+1, preorder_left+sizeOfLeftTree, inorder_left, inorder_root-1);

            node.right = build(preorder, inorder, preorder_left+sizeOfLeftTree+1, preorder_right, inorder_root+1, inorder_right);

            return node;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            //记录中序遍历中节点的位置
            for (int i = 0; i < n; i++) {
                map.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, n-1, 0, n-1);
        }
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};

        Solution solution = new Solution();
        TreeNode node = solution.buildTree(preorder, inorder);

    }
}
