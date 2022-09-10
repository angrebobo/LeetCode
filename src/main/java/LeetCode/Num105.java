package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 11:03 2021/10/9
 */
public class Num105 {

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

    /**
     *  2022.03.15日写
     */
    /*static class Solution {
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
    }*/

        // 2020.08.01写
    /*static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // map保存节点在中序遍历里的索引位置
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < preorder.length; i++){
                for(int j = 0; j < inorder.length; j++){
                    if(preorder[i] == inorder[j])
                        map.put(preorder[i], j);
                }
            }

            return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1, map);
        }

        public TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right, HashMap<Integer, Integer> map){
            if(pre_left > pre_right)
                return null;

            // preorder[pre_left] 就是root节点
            TreeNode root = new TreeNode(preorder[pre_left]);
            int index = map.get(preorder[pre_left]);
            int len1 = index - in_left;
            // int len2 = in_right - index;

            root.left = build(preorder, inorder, pre_left+1, pre_left+len1, in_left, index-1, map);
            root.right = build(preorder, inorder, pre_left+len1+1, pre_right, index+1, in_right, map);

            return root;
        }
    }*/

        // 2022.09.10写
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
        }

        public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            // 注意递归结束的条件
            // 当前节点如果是叶子节点，那preStart==preEnd
            // 叶子节点在创建左右子节点时，preStart > preEnd， return null
            if(preStart > preEnd)
                return null;

            int rootVal = preorder[preStart];
            TreeNode root = new TreeNode(rootVal);
            int rootIndex = 0;
            for (int i = 0; i < inorder.length; i++) {
                if(inorder[i] == rootVal){
                    rootIndex = i;
                    break;
                }
            }

            int leftTreeSize = rootIndex - inStart;

            root.left = build(preorder, preStart+1, preStart+leftTreeSize, inorder, inStart, rootIndex-1);

            root.right = build(preorder, preStart+leftTreeSize+1, preEnd, inorder, rootIndex+1, inEnd);

            return root;
        }
    }

    // 这道题还有变种
    // 题目：已知一个二叉树的先序遍历序列和中序遍历序列，但其中一些节点的值可能相同，请你返回所有满足条件的二叉树。二叉树在数组中的顺序是任意的。
    // 用例：输入描述：[1,1,2],[1,2,1]
    // 输出描述：[{1,1,#,#,2｝,{1,#,1,2｝]
    // 链接：https://mp.weixin.qq.com/s/PgHcLid5Ed4-WasgnhxEpg
    static class Solution1{
        public ArrayList<TreeNode> buildTree(int[] preorder, int[] inorder) {
            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);

        }

        public ArrayList<TreeNode> build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd){
            if(preStart > preEnd || inStart > inEnd)
                return new ArrayList<>();

            int rooVal = preorder[preStart];
            List<Integer> canditate = new ArrayList<>();
            for (int i = inStart; i <= inEnd; i++) {
                if(inorder[i] == rooVal)
                    canditate.add(i);
            }

            ArrayList<TreeNode> res = new ArrayList<>();

            if(canditate.size() > 0){
                for (Integer index : canditate) {
                    int leftTreeSize = index - preStart;

                    ArrayList<TreeNode> left = build(preorder, preStart+1, preStart+1+leftTreeSize, inorder, inStart, index-1);
                    ArrayList<TreeNode> right = build(preorder, preStart+1+leftTreeSize+1, preEnd, inorder, index+1, inEnd);
                    for (TreeNode l : left) {
                        for (TreeNode r : right) {
                            TreeNode root = new TreeNode(rooVal);
                            root.left = l;
                            root.right = r;
                            res.add(root);
                        }
                    }
                }
            }

            return res;
        }
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{1,1,2};
        int[] inorder = new int[]{1,2,1};

//        Solution solution = new Solution();
//        TreeNode node = solution.buildTree(preorder, inorder);

        Solution1 solution1 = new Solution1();
        ArrayList<TreeNode> nodes = solution1.buildTree(preorder, inorder);
    }
}
